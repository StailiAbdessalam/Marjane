package Dao;
import Models.Center;
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

    public Center getpromotionByName(String name) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select c from Center c WHERE c.cname = :name", Center.class)
                    .setParameter("name", name)
                    .getSingleResult();
        });
    }

    public void createPromotion(Center category) {
        create(category);
    }

    public void deletePromotion(Center category) {
        delete(category);
    }

}

