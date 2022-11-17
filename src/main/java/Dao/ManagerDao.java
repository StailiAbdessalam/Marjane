package Dao;

import Models.Manager;
import jakarta.persistence.NoResultException;

import java.util.List;

import static Utuls.Password.checkPassword;

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

    // find one manager by email and password
    public static boolean validateRespRayonLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        Manager admin = new ManagerDao().getManagerByemail(email);
        assert admin != null;
        if(admin != null) {
            if (checkPassword(password, admin.getMpassword())) {

                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    // find one manager by email
    public Manager getManagerByemail(String email) {

        return jpaService.runInTransaction(entityManager -> {
            try{
                return entityManager.createQuery("select a from Manager a WHERE a.memail = :email", Manager.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException nre){
                return null;
            }
        });

    }

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
