import org.apache.commons.lang3.reflect.FieldUtils;
import ultis.EntityManagerHelper;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class GenericRepository<T> {
    private Class<T> entityClass;
    private final String fieldId = "id";
    private final String createAtTime = "create_time";
    private final String updateAtTime = "update_time";
    private CriteriaBuilder criteriaBuilder;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.criteriaBuilder = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
    }

    protected T getById(int id) throws Exception {

        try {
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<T> root = criteriaQuery.from(entityClass);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get(fieldId), id));
            return EntityManagerHelper.getEntityManager().createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        } catch (Exception ex) {
            EntityManagerHelper.rollBackThenClose();
            throw ex;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    protected List<T> getAll() throws Exception {
        try {
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<T> root = criteriaQuery.from(entityClass);
            criteriaQuery.select(root);
            return EntityManagerHelper.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (NoResultException ignored) {
            return null;
        } catch (Exception ex) {
            EntityManagerHelper.rollBackThenClose();
            throw ex;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    protected void create(T entity) throws Exception {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        try {
            FieldUtils.writeDeclaredField(entity, updateAtTime, time, true);
            FieldUtils.writeDeclaredField(entity, createAtTime, time, true);
            EntityManagerHelper.getEntityManager().persist(entity);
        } catch (Exception ex) {
            EntityManagerHelper.rollBackThenClose();
            throw ex;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    protected void update(T entity) throws Exception {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        try {
            FieldUtils.writeDeclaredField(entity, updateAtTime, time, true);
            EntityManagerHelper.getEntityManager().merge(entity);
        } catch (Exception ex) {
            EntityManagerHelper.rollBackThenClose();
            throw ex;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}
