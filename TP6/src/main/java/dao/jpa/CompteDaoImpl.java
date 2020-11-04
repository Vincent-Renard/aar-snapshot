package dao.jpa;

import dao.CompteDao;
import model.Compte;

/**
 * @autor Vincent
 * @date 04/11/2020
 */

public class CompteDaoImpl extends AbstractDaoImpl<Compte> implements CompteDao {

    public CompteDaoImpl() {
        this(Compte.class);
    }

    public CompteDaoImpl(Class<Compte> entityClass) {
        super(entityClass);
    }
}

