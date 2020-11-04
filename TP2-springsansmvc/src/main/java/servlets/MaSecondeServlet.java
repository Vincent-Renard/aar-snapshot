package servlets;

import modele.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MaSecondeServlet", urlPatterns = "/autre")
public class MaSecondeServlet extends HttpServlet {
    // Pour illustrer que l'on injecte bien le même composant qu'avec l'autre servlet...
    // ... ou pas ...
    @Autowired
    private Service2 service2;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        response.getWriter().print("nom: " + nom + " ,nomr: " + service2.reverse(nom));
        request.setAttribute("nomr", service2.reverse(nom));
        request.getRequestDispatcher("/WEB-INF/serv2.jsp").forward(request, response);
        return;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
