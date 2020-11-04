package servlets;

import modele.Service1;
import modele.Service2;
import modele.Service3;
import modele.Service5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// Ce servlet illustre divers problèmes d'autowired et leur solution
// Attention : il n'est pas conseillé d'avoir plusieurs beans dans un servlet
// (privilégier le principe de la facade)
@WebServlet(name = "Controleur", urlPatterns = "/control")
public class MaServlet extends HttpServlet {
    // l'ambiguité est résolue par nom de la variable (qualifier implicite)
    @Autowired
    private Service1 service1Impl1;

    // l'ambiguité est résolue par qualifier explicite
    @Autowired
    @Qualifier("english")
    private Service1 service1;

    // Là pas d'ambiguité, une seule lasse implémente le service
    @Autowired
    private Service2 service2;

    // Pour illustrer que l'on injecte bien le même composant
    @Autowired
    private Service2 service2Autre;


    // Là non plus, le service est une classe sans interface...
    @Autowired
    private Service3 service3;


    // ce service là est défini dans application-context.xml
    @Inject
    private Service5 service5;

    // Cette resource est définie dans web.xml
    @Resource(name = "motdujour")
    String motdj;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo = request.getParameter("TODO");
        if (todo != null) {
            switch (todo) {
                case "login":
                    String nom = request.getParameter("nom");
                    request.setAttribute("message1", service1Impl1.hello(nom));
                    request.setAttribute("message1bis", service1.hello(nom));
                    request.setAttribute("message2", service2.reverse(nom));
                    request.setAttribute("message3", service3.codeUnique());
                    request.setAttribute("message5", service5.doIt());
                    request.setAttribute("message6", motdj);
                    request.setAttribute("serviceId", service2.toString());
                    request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
                    return;
            }
        }
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
