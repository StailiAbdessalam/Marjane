package Dao;
import Models.Categorie;
import Models.Center;

import java.util.List;
public class CategorieDao extends AbstractHibernateDao<Categorie> {

    public CategorieDao() {
        tableName = "categorie";
        setClazz(Categorie.class);
    }

    // find all categories
    public List getAllCategories() {
        return findAll();
    }
    // find all categorie by don't use
    public List getAllCategorieDisponible()  {
        return jpaService.runInTransaction(entityManager -> {
            return   entityManager.createQuery("SELECT c FROM Categorie c WHERE c.id NOT IN (SELECT a.midcategorie FROM Manager a)", Center.class).getResultList();
        });
    }

    // find one category by id
    public Categorie getCategoryById(long id) {
        return findOne(id);
    }

    // create category
    public void createCategory(Categorie category) {
        create(category);
    }
    // update category
    public Categorie updateCategory(Categorie category) {
        return update(category);
    }
    // delete category
    public void deleteCategory(Categorie category) {
        delete(category);
    }
    // delete category by id
    public void deleteCategoryById(long id) {
        deleteById(id);
    }


}

