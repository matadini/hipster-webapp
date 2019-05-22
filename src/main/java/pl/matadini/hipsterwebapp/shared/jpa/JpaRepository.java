package pl.matadini.hipsterwebapp.shared.jpa;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, PK> {

    T save(T entity);

    Optional<T> findById(PK id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

    PK count();

}