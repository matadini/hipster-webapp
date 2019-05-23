package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;
import pl.matadini.hipsterwebapp.shared.test.H2Test;

class AuthorServiceTest extends H2Test {

	AuthorService service;

	@BeforeEach
	@Override
	protected void beforeEach() {
		super.beforeEach();
		service = AuthorServiceFactory.create(entityManagerFactory);
	}

	@Test
	void create_whenInvalidDto_thenThrowException() {

		Assertions.assertThrows(AuthorServiceException.class, () -> {

			AuthorSaveDto dto = AuthorTestSampleFactory.createInvalidSaveDto();

			service.addAuthor(dto);
		});

	}

	@Test
	void create_whenCorrectDto_thenCreateAuthor() throws AuthorServiceException {

		AuthorSaveDto dto = AuthorTestSampleFactory.createStandardSaveDto();

		Long addAuthor = service.addAuthor(dto);
		Assertions.assertNotNull(addAuthor);
	}

	@Test
	void getAll_whenNoAuthorsInDb_thenReturnEmptyList() throws AuthorServiceException {

		// given

		// when
		List<AuthorDto> all = service.getAll();

		// then
		Assertions.assertNotNull(all);
		Assertions.assertTrue(all.isEmpty());
	}

	@Test
	void getAll_whenAuthorsInDb_thenReturnThem() throws AuthorServiceException {

		// given
		service.addAuthor(AuthorTestSampleFactory.createStandardSaveDto());
		service.addAuthor(AuthorTestSampleFactory.createStandardSaveDto());

		// when
		List<AuthorDto> all = service.getAll();
		
		// then
		Assertions.assertEquals(2, all.size());

	}
}
