package Utuls;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.function.Function;

public class JpaService {
    private static JpaService instance;
    private final EntityManagerFactory entityManagerFactory;

    public JpaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    }

    public static JpaService getInstance() {
        return instance == null ? instance = new JpaService() : instance;
    }
    // shutdown the EntityManagerFactory
    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
    public <T> T runInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            T result = function.apply(entityManager);
            entityTransaction.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }


}
