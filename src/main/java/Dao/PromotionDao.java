package Dao;

import Models.Promotion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class PromotionDao extends AbstractHibernateDao<Promotion> {
    public PromotionDao() {
        tableName = "Promotion";
        setClazz(Promotion.class);
    }
    public List getAllPromotion() {
        return findAll();
    }
    public Promotion getpromotionById(long id) {
        return findOne(id);
    }
    public void createPromotion(Promotion promotion) {
        create(promotion);
    }
    public void deletepromo(long idpromotion) {
        deleteById(idpromotion);
    }
    public List getPromotionByStatus(String status) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Promotion p where p.pStatus = :status", Promotion.class)
                    .setParameter("status", status)
                    .getResultList();
        });
    }
    public void updateStatus(Promotion p, String status) {
        p.setPStatus(status);
        update(p);
    }

    public List getAllPromotionByIdCategory(Long id){
        List<Promotion> promotions = new ArrayList<>();
        LocalTime currentTime = LocalTime.now();
//        if (currentTime.isAfter(LocalTime.of(8, 0)) && currentTime.isBefore(LocalTime.of(19, 30))) {
            promotions = jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("SELECT p FROM Promotion p WHERE p.pCategorie.id=:id", Promotion.class)
                        .setParameter("id",id)
                        .getResultList();
            });
//        }else{
//            return null;
//        }
        return promotions;
    }

    public List<Promotion> getAllPromotionByIdAdminCenter(Long id){
        List<Promotion> promotions = new ArrayList<>();
        LocalTime currentTime = LocalTime.now();
//        if (currentTime.isAfter(LocalTime.of(8, 0)) && currentTime.isBefore(LocalTime.of(00, 30))) {
            promotions = jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("SELECT p FROM Promotion p WHERE p.pIdcenteradmin.id=:id", Promotion.class)
                        .setParameter("id",id)
                        .getResultList();
            });
//        }else{
//            return null;
//        }
        return promotions;
    }
}

