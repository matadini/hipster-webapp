package pl.matadini.hipsterwebapp.context.person;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import lombok.AllArgsConstructor;
import pl.matadini.hipsterwebapp.shared.jpa.JpaRepositoryUtil;

@AllArgsConstructor
class PersonRepositoryImpl implements PersonRepository {

	EntityManager entityManager;

	@Override
	public Person save(Person entity) {
		return JpaRepositoryUtil.merge(entity, entityManager);
	}

	@Override
	public Optional<Person> findById(Long id) {
		Person find = entityManager.find(Person.class, id);
		return Optional.ofNullable(find);
	}

	@Override
	public void delete(Person entity) {
		JpaRepositoryUtil.delete(entity, entityManager);
	}

	@Override
	public List<Person> findAll() {
		String qlString = "select p from Person p order by p.personId";
		TypedQuery<Person> query = entityManager.createQuery(qlString, Person.class);
		return query.getResultList();
	}

	@Override
	public void deleteAll() {

		Query query = entityManager.createQuery("delete from Person p");
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
	}

	@Override
	public Long count() {
		String qlString = "select count(p.personId) from Person p ";
		TypedQuery<Long> createQuery = entityManager.createQuery(qlString, Long.class);
		return createQuery.getSingleResult();
	}

}