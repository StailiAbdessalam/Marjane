package Dao;


import Models.Admingeneral;
import jakarta.persistence.NoResultException;

import static Utuls.Password.checkPassword;

public class AdminGeneralDao extends AbstractHibernateDao<Admingeneral> {
    public AdminGeneralDao() {
        tableName = "admingeneral";
        setClazz(Admingeneral.class);
    }

    // find one admin by email
    public Admingeneral getAdminByEmail(String email) {

        return jpaService.runInTransaction(entityManager -> {
            try{
                return entityManager.createQuery("select a from Admingeneral a WHERE a.agemail = :email", Admingeneral.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException nre){
                return null;
            }
        });

    }

    // validate admin by email and password
    public boolean validateAdminLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        Admingeneral admin = getAdminByEmail(email);
        assert admin != null;
        if(admin != null) {
            if (checkPassword(password, admin.getAgpassword())) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
    // update admin
    public Admingeneral updateAdmin(Admingeneral admin) {
        return update(admin);
    }
}


