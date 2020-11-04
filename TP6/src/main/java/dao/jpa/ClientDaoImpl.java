package dao.jpa;

import dao.ClientDao;
import model.Client;

/**
 * @autor Vincent
 * @date 04/11/2020
 */

public class ClientDaoImpl extends AbstractDaoImpl<Client> implements ClientDao {
    public ClientDaoImpl() {
        this(Client.class);
    }

    public ClientDaoImpl(Class<Client> entityClass) {
        super(entityClass);
    }
}
