package pl.matadini.hipsterwebapp.shared.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JpaRepositoryUtil {

    public static <T, PK> T read(Class<T> entityClass, PK id, EntityManager entityManager) {
        return entityManager.find(entityClass, id);
    }


    public static <T> T merge(T entity, EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entity = entityManager.merge(entity);
        transaction.commit();
        return entity;
    }

    public static <T> void delete(T entity, EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }
}
