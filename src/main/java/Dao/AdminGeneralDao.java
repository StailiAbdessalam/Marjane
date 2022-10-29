package Dao;


import Models.Admingeneral;
import jakarta.persistence.NoResultException;

import java.util.List;

import static Utuls.Password.checkPassword;
import static Utuls.Password.hashPassword;
import static helpers.Sout.sout;
public class AdminGeneralDao extends AbstractHibernateDao<Admingeneral> {
    public AdminGeneralDao() {
        tableName = "admingeneral";
        setClazz(Admingeneral.class);
    }
    // find all admins
    public List getAllAdmins() {
        return findAll();
    }

    // find one admin by id
    public Admingeneral getAdminById(long id) {
        return findOne(id);
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

    // find one admin by email and password
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

    // delete admin
    public void deleteAdmin(Admingeneral admin) {
        delete(admin);
    }

    // delete admin by id
    public void deleteAdminById(long id) {
        deleteById(id);
    }

//    public static void main(String[] args) {
//        AdminGeneralDao superAdminDao = new AdminGeneralDao();
//        Admingeneral superAdminEntity = new Admingeneral();
//        superAdminEntity.setAgemail("sa@admin.com");
//        superAdminEntity.setAgpassword(hashPassword("admin"));
//        superAdminEntity.setAgfullname("abdessalam staili");
//        superAdminDao.create(superAdminEntity);
//    }
}


