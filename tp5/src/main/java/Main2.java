import model.Client;
import model.Compte;
import model.Livret;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @autor Vincent
 * @date 21/10/2020
 */

public class Main2 {

    private static final String PERSISTANCE_UNIT_NAME = "banquePU";

    public static void main(String... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);

        var entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();


        try {
            tx.begin();

            Client c0 = new Client("Riri", "Duck", "8 rue BP Canarville");
            Client c1 = new Client("Fifi", "Duck", "8 rue BP Canarville");
            Client c2 = new Client("Loulou", "Duck", "8 rue BP Canarville");


            Livret livretac0 = new Livret(3.0, 0.15);
            Compte compteac0 = new Compte(3.0);
            c0.addCompte(compteac0);
            c0.addCompte(livretac0);

            Livret livretac1 = new Livret(313.0, 0.15);

            c0.addCompte(compteac0);
            c0.addCompte(livretac0);

            c1.addCompte(livretac1);

            Compte compteac2 = new Compte(0.0);
            c2.addCompte(compteac2);
            entityManager.persist(c0);


            entityManager.persist(c1);
            entityManager.persist(c2);


            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            entityManager.close();
        }

    }
}
