package servlets;

import model.Membre;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @autor Vincent
 * @date 09/09/2020
 */

public class Controler extends HttpServlet {
    private Service service = new Service();


    public Controler() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();

        service.addMembre("Richard","rduck","Riri");
        service.addMembre("Firmin","fduck","Fifi");
        service.addMembre("Louis","lduck","Loulou");
        service.addMembre("Donald","dduck","Onc");

        service.addCompetence("Java","La base quoi");
        service.addCompetence("PHP","La souffrance quoi");
        service.addCompetence("C","C'est plus plus ce que c'était");
        service.addCompetence("Scrum","L'orga de base");

        service.addProjet("Projet 1 ","Le premier projet");
        service.addProjet("Projet 2 ","Le deuxieme projet");
        service.addProjet("Projet 3 ","Le troisieme projet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo = request.getParameter("TODO");
        if (todo == null) {
            request.getRequestDispatcher("/WEB-INF/accueil.jsp").
                    forward(request, response);
        } else {
            if (todo.equals("selogguer")) {
                String log = request.getParameter("login");
                String mdp = request.getParameter("mdp");
                Optional<Membre> optM = service.findMembreByLogin(log);

                if (optM.isPresent()) {
                    Membre m = optM.get();
                    if (m.getMotdepasse().equals(mdp)) {
                        // le login est mis en session pour s'en souvenir...
                        request.getSession().setAttribute("util", log);
                        // on affiche la page de menu, en lui passant le membre (m) qui vient de se logguer
                        request.setAttribute("courant", m);
                        request.getRequestDispatcher("/WEB-INF/menu.jsp").
                                forward(request, response);
                    }
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
