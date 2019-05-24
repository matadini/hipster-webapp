package pl.matadini.hipsterwebapp.context.blog.article;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.context.blog.author.AuthorService;
import pl.matadini.hipsterwebapp.context.blog.author.AuthorServiceException;
import pl.matadini.hipsterwebapp.context.blog.author.AuthorServiceFactory;
import pl.matadini.hipsterwebapp.shared.test.H2Test;

class ArticleAuthorRepositoryTest extends H2Test {

	ArticleAuthorRepository articleAuthorRepository;

	AuthorService authorService;

	@BeforeEach
	@Override
	protected void beforeEach() {
		super.beforeEach();
		articleAuthorRepository = ArticleAuthorRepository.create(entityManagerFactory.createEntityManager());
		authorService = AuthorServiceFactory.create(entityManagerFactory);
	}

	@Test
	void testFindById() throws AuthorServiceException {
		// given
		authorService.addAuthor(ArticleTestSample.createAuthorSaveDto0());
		Long addAuthor = authorService.addAuthor(ArticleTestSample.createAuthorSaveDto1());

		// when
		Optional<ArticleAuthor> findById = articleAuthorRepository.findById(addAuthor);

		// then
		Assertions.assertTrue(findById.isPresent());
	}

	@Test
	void testFindAll() throws AuthorServiceException {
		// given
		authorService.addAuthor(ArticleTestSample.createAuthorSaveDto0());
		authorService.addAuthor(ArticleTestSample.createAuthorSaveDto1());

		// when
		List<ArticleAuthor> findAll = articleAuthorRepository.findAll();

		// then
		Assertions.assertEquals(2, findAll.size());
	}
}
