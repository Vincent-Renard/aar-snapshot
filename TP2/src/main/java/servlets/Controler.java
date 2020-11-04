package servlets;

import model.Facade;
import model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @autor Vincent
 * @date 09/09/2020
 */
@WebServlet(name = "Controleur", urlPatterns = "/control")
public class Controler extends HttpServlet {

    @Autowired
    private Facade facade;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String whereDoYouWannaGo = request.getParameter("go");
        if (whereDoYouWannaGo == null) {

            request.getRequestDispatcher("/WEB-INF/accueil.jsp").
                    forward(request, response);
            return;
        } else if (whereDoYouWannaGo.equals("log")) {
            String log = request.getParameter("login");
            String mdp = request.getParameter("mdp");


            Optional<Membre> optM = facade.findMembreByLogin(log);
            if (optM.isPresent()) {
                Membre m = optM.get();
                if (m.getMotdepasse().equals(mdp)) {
                    // le login est mis en session pour s'en souvenir...
                    request.getSession().setAttribute("utilisateur", log);
                    // on affiche la page de menu, en lui passant le membre (m) qui vient de se logguer
                    request.setAttribute("courant", m);
                    System.out.println("hello");
                    request.getRequestDispatcher("/WEB-INF/menu.jsp").
                            forward(request, response);

                    return;
                }
            }
        }


        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
