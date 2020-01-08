package ultis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerHelper {
    private static EntityManagerFactory entityManagerFactory;
    private static ThreadLocal<EntityManager> threadLocal;
    static {
        entityManagerFactory = HibrenateHelper.getEntityManagerFactory();
        threadLocal = new ThreadLocal<>();

    }
    public static EntityManager getEntityManager(){
        EntityManager em = threadLocal.get();
        if(em == null){
            em = entityManagerFactory.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }
    public static void closeEntityManager(){
        EntityManager em = threadLocal.get();
        if(em == null){
            return;
        }
        if(em.isOpen() ){
            em.close();
            threadLocal.set(null);
        }
    }

    public static void beginTranstion(){
        EntityManager em = threadLocal.get();
        if (em != null && em.getTransaction().isActive()) return;
        getEntityManager().getTransaction().begin();
    }
    public static void rollBackThenClose(){
        EntityManager em = threadLocal.get();
        if(em == null){
            return;
        }
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }
        em.close();
        threadLocal.set(null);
    }
    public static void commitThenClose(){
        EntityManager em = threadLocal.get();
        if(em == null){
            return;
        }
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        em.close();
        threadLocal.set(null);
    }

}
