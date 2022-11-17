package Dao;

import Models.Centreadmin;
import jakarta.persistence.NoResultException;

import java.util.List;

import static Utuls.Password.checkPassword;


public class AdminCenterDao extends AbstractHibernateDao<Centreadmin> {
    public AdminCenterDao() {
        tableName = "centreadmin";
        setClazz(Centreadmin.class);
    }

    public Integer validateadminGeneralLogin(Object[] login){
        String email = (String) login[0];
        String password = (String) login[1];
        Centreadmin admin = getadmincenterByEmail(email);

        assert admin != null;
        if(admin != null) {
            if (checkPassword(password, admin.getCapassword())) {
                return admin.getId();
            } else {
                return null;
            }
        }else {
            return null;
        }
    }
    public  List getAlladminCenter() {
        return findAll();
    }

    public Centreadmin getadmincenterByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            try{
                return entityManager.createQuery("select a from Centreadmin a WHERE a.caemail = :email", Centreadmin.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException nre){
                return null;
            }
        });

    }
    public Centreadmin getadmincenterbyid(long id) {
        return findOne(id);
    }
    // add admin center
    public void addadminCenter(Centreadmin centreadmin){
        create(centreadmin);
    }
    // delete admin center
    public void deleteadminGeneral(Centreadmin centerAdmin) {
        delete(centerAdmin);
    }


}
