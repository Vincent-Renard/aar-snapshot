package persistance;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import model.Client;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashSet;

/**
 * @autor Vincent
 * @date 14/10/2020
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersistanceEngine {

    private static final String PERSISTANCE_UNIT_NAME = "banquePU";
    EntityManagerFactory emf;
    public PersistanceEngine() {
        emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
    }

    public Client insertClient(String prenom,String nom,String addresse){
        var entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            Client c0 = new Client();
            c0.setNom(nom);
            c0.setPrenom(prenom);
            c0.setAdresse(addresse);
            entityManager.persist(c0);
            tx.commit();
            return c0;
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            entityManager.close();
        }

        return null;
    }

    public Collection<Client> findAllClients() {
        var entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        Collection<Client> cs = new HashSet<>();

        try {
            //entityManager.find()
            return cs;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return null;
    }
}
