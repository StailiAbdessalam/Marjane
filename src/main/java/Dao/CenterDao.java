package Dao;
import Models.Center;

import java.util.ArrayList;
import java.util.List;
public class CenterDao extends AbstractHibernateDao<Center> {

    public CenterDao() {
        tableName = "Center";
        setClazz(Center.class);
    }

    // find all center
    public List getAllCenters() {
        return findAll();
    }
    // find center by id
    public Center getCenterById(long id) {
        return findOne(id);
    }

    public List getAllCenterDisponible()  {
        return jpaService.runInTransaction(entityManager -> {
            return   entityManager.createQuery("SELECT c FROM Center c WHERE c.id NOT IN (SELECT a.idcenter FROM Centreadmin a)", Center.class).getResultList();
        });
    }
    public void createCeter(Center category) {
        create(category);
    }

}

