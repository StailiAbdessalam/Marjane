package Dao;
import Models.Promotion;

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

    public void deleteCategory(Promotion promotion) {
        delete(promotion);
    }

}

