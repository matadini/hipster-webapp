package pl.matadini.hipsterwebapp.context.person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.shared.test.H2Test;

class PersonRepositoryTest extends H2Test {

	PersonRepository repository;

	@Override
	@BeforeEach
	protected void beforeEach() {
		super.beforeEach();
		repository = PersonRepository.create(entityManagerFactory.createEntityManager());
	}

	@Test
	void testSave() {

		// given
		repository.save(new Person("a", "a"));
		repository.save(new Person("b", "b"));

		// when
		Long count = repository.count();

		// then
		Assertions.assertEquals(2, count.longValue());
	}

	@Test
	void testFindById() {

		// given
		Person save = repository.save(new Person("a", "a"));

		// when
		Optional<Person> findById = repository.findById(save.getPersonId());

		// then
		Assertions.assertTrue(findById.isPresent());
		Assertions.assertTrue(save.equals(findById.get()));
	}

	@Test
	void testDelete() {

		// given
		Person save = repository.save(new Person("a", "a"));

		// when
		repository.delete(save);

		// then
		Optional<Person> findById = repository.findById(save.getPersonId());
		Assertions.assertFalse(findById.isPresent());
	}

	@Test
	void testFindAll() {

		// given
		repository.save(new Person("a", "a"));
		repository.save(new Person("b", "b"));

		// when
		List<Person> findAll = repository.findAll();

		// then
		Assertions.assertEquals(2, findAll.size());
	}

	@Test
	void testDeleteAll() {

		// given
		repository.save(new Person("a", "a"));
		repository.save(new Person("b", "b"));
		
		// when
		repository.deleteAll();
		
		// then
		Assertions.assertEquals(0, repository.count().longValue()); 
	}

}
