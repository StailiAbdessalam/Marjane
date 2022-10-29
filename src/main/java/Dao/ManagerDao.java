package Dao;

import Dao.AbstractHibernateDao;
import Models.Manager;

import java.util.List;

public class ManagerDao extends AbstractHibernateDao<Manager> {

    public ManagerDao() {
        tableName = "manager";
        setClazz(Manager.class);
    }

    // find all manager
    public List getAllRespRayons() {
        return findAll();
    }

    // find one manager by id
    public Manager getRespRayonById(long id) {
        return findOne(id);
    }

    // find one manager by email
    public Manager getRespRayonByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select r from Manager r WHERE r.memail = :email", Manager.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // find one manager by email and password
    public static boolean validateRespRayonLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select r from Manager r WHERE r.memail = :email and r.mpassword = :password", Manager.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList().size() > 0;
        });
    }

    // create manager

    /**
     * Create manager.
     * @param manager Manager
     */
    public void createRespRayon(Manager manager) {
        create(manager);
    }

    // update manager
    public Manager updateRespRayon(Manager manager) {
        return update(manager);
    }

    // delete manager
    public void deleteRespRayon(Manager manager) {
        delete(manager);
    }

    // delete manager by id
    public void deleteRespRayonById(long id) {
        deleteById(id);
    }


}
