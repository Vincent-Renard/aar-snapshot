package dao.jpa;

import dao.LivretDao;
import model.Livret;

/**
 * @autor Vincent
 * @date 04/11/2020
 */

public class LivretDaoImpl extends AbstractDaoImpl<Livret> implements LivretDao {

    public LivretDaoImpl() {
        this(Livret.class);
    }

    public LivretDaoImpl(Class<Livret> entityClass) {
        super(entityClass);
    }
}
