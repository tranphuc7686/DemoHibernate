package ultis;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibrenateHelper {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
