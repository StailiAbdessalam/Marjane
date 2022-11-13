package Dao;
import Models.Center;

import java.util.ArrayList;
import java.util.List;
public class CenterDao extends AbstractHibernateDao<Center> {

    public CenterDao() {
        tableName = "Center";
        setClazz(Center.class);
    }

    public List getAllCenters() {
        return findAll();
    }

    public Center getCenterById(long id) {
        return findOne(id);
    }

    public List getAllCenterDisponible()  {
        return jpaService.runInTransaction(entityManager -> {
            return   entityManager.createQuery("SELECT c FROM Center c WHERE c.id NOT IN (SELECT a.idcenter FROM Centreadmin a)", Center.class).getResultList();
        });
    }

    public Center getpromotionByName(String name) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select c from Center c WHERE c.cname = :name", Center.class)
                    .setParameter("name", name)
                    .getSingleResult();
        });
    }

    public void createCeter(Center category) {
        create(category);
    }

    public void deleteCenter(Center category) {
        delete(category);
    }

}

