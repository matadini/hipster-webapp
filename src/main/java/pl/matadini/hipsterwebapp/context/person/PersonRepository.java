package pl.matadini.hipsterwebapp.context.person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

interface PersonRepository extends JpaRepository<Person, Long> {

	static PersonRepository create(EntityManager entityManager) {
		return new PersonRepositoryImpl(entityManager);
	}
}
