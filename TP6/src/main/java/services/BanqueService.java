package services;

import model.Client;
import model.Compte;
import model.Livret;

import java.util.Collection;

/**
 * @autor Vincent
 * @date 04/11/2020
 */

public interface BanqueService {
    void virement(long source, long destination, double montant);

    Collection<Client> getAllClients();

    Client getClient(long id);

    void deleteClient(long id);

    void saveClients(Client... clients);

    Collection<Compte> getAllComptes();

    Collection<Compte> getComptesOfClient(long idClient);

    Collection<Livret> getAllLivrets();
}
