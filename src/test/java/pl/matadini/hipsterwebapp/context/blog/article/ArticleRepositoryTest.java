package pl.matadini.hipsterwebapp.context.blog.article;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pmw.tinylog.Logger;

import pl.matadini.hipsterwebapp.context.blog.author.AuthorService;
import pl.matadini.hipsterwebapp.context.blog.author.AuthorServiceException;
import pl.matadini.hipsterwebapp.context.blog.author.AuthorServiceFactory;
import pl.matadini.hipsterwebapp.shared.test.H2Test;

class ArticleRepositoryTest extends H2Test {

	ArticleRepository articleRepository;

	Article articleSample0;
	
	Article articleSample1;
	
	@BeforeEach
	@Override
	protected void beforeEach() {
		super.beforeEach();

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		articleRepository = ArticleRepository.create(entityManager);

		try {
			AuthorService service = AuthorServiceFactory.create(entityManagerFactory);
			Long addAuthor = service.addAuthor(ArticleTestSample.createAuthorSaveDto0());
			
			ArticleAuthorRepository create = ArticleAuthorRepository.create(entityManager);
			Optional<ArticleAuthor> findById = create.findById(addAuthor);
			ArticleAuthor articleAuthor = findById.get();
			
			articleSample0 = new Article(null, "title-0", "content-0", articleAuthor);
			articleSample1 = new Article(null, "title-1", "content-1", articleAuthor);
			
		} catch (Exception ex) {
			Logger.error(ex);
			fail("Not yet implemented");
		}
	}

	@Test
	void testCreate() {
		
		// given
		
		// when
		Article entity = articleRepository.save(articleSample0);
		
		// then
		Optional<Article> findById = articleRepository.findById(entity.getArticleId());
		Assertions.assertTrue(findById.isPresent());
	}

	@Test
	void testRead() {
		
		// given
		Long entity = articleRepository.save(articleSample0).getArticleId();
		
		// when
		Optional<Article> findById = articleRepository.findById(entity);
		
		// then
		Assertions.assertTrue(findById.isPresent());
	}
	
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCount() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDeleteAll() {
		fail("Not yet implemented");
	}
}
