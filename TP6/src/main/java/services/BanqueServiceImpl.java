package services;

import dao.ClientDao;
import dao.CompteDao;
import dao.LivretDao;
import model.Client;
import model.Compte;
import model.Livret;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @autor Vincent
 * @date 04/11/2020
 */

public class BanqueServiceImpl implements BanqueService {

    private ClientDao clients;
    private CompteDao comptes;
    private LivretDao livrets;

    public BanqueServiceImpl(@Autowired ClientDao clients,
                             @Autowired CompteDao comptes,
                             @Autowired LivretDao livrets) {
        this.clients = clients;
        this.comptes = comptes;
        this.livrets = livrets;
    }

    @Override
    @Transactional
    public void virement(long source, long destination, double montant) {
        Compte src = comptes.find(source);
        Compte dest = comptes.find(destination);

        src.setSolde(src.getSolde() - montant);
        dest.setSolde(dest.getSolde() + montant);
        comptes.edit(src);
        comptes.edit(dest);
    }

    @Override
    public Collection<Client> getAllClients() {
        return clients.findAll();
    }

    @Override
    public Client getClient(long id) {
        return clients.find(id);
    }

    @Override
    @Transactional
    public void deleteClient(long id) {
        clients.remove(getClient(id));

    }

    @Override
    @Transactional
    public void saveClients(Client... clientss) {
        for (Client client : clientss) {
            clients.create(client);
        }

    }

    @Override
    public Collection<Compte> getAllComptes() {

        return comptes.findAll();
    }

    @Override
    public Collection<Compte> getComptesOfClient(long idClient) {

        return clients.find(idClient).getComptes();
    }

    @Override
    public Collection<Livret> getAllLivrets() {
        return livrets.findAll();
    }
}
