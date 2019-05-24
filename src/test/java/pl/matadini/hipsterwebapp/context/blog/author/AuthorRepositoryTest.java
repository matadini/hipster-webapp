package pl.matadini.hipsterwebapp.context.blog.author;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.shared.test.H2Test;

class AuthorRepositoryTest extends H2Test {

	AuthorRepository authorRepository;

	@BeforeEach
	@Override
	protected void beforeEach() {
		super.beforeEach();
		authorRepository = AuthorRepository.create(entityManagerFactory.createEntityManager());
	}

	@Test
	void testCreate() {

		// given
		Author entity = AuthorTestSampleFactory.createStandardEntity();

		// when
		authorRepository.save(entity);

		// then
		Long count = authorRepository.count();
		Assertions.assertEquals(1, count.longValue());
	}

	@Test
	void testRead() {

		// given
		Long authorId = authorRepository.save(AuthorTestSampleFactory.createStandardEntity()).getAuthorId();

		// when
		Optional<Author> findById = authorRepository.findById(authorId);

		// then
		Assertions.assertTrue(findById.isPresent());
	}

	@Test
	void testUpdate() {

		// given
		Author entity = authorRepository.save(AuthorTestSampleFactory.createStandardEntity());
		Long authorId = entity.getAuthorId();

		// when
		entity.setName("new-name");
		authorRepository.save(entity);

		// then
		Author entityRead = authorRepository.findById(authorId).get();
		Assertions.assertEquals("new-name", entityRead.getName());
	}

//	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testCount() {
		// given
		authorRepository.save(AuthorTestSampleFactory.createStandardEntity());
		authorRepository.save(AuthorTestSampleFactory.createStandardEntity());

		// when
		Long count = authorRepository.count();

		// then
		Assertions.assertEquals(2, count.longValue());
	}

	
//	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

}
