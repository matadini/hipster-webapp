package pl.matadini.hipsterwebapp.context.blog.author;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;
import pl.matadini.hipsterwebapp.shared.test.H2Test;

class AuthorServiceTest extends H2Test {

	AuthorService service;

	@BeforeEach
	void test() {
		super.beforeEach();
		service = AuthorServiceFactory.create(entityManagerFactory);
	}

	@Test
	void create_whenInvalidDto_thenThrowException() {

		Assertions.assertThrows(AuthorServiceException.class, () -> {

			AuthorSaveDto dto = AuthorSaveDto.builder()
					.name("author-name")
					.surname("author-surname")
					.build();
			
			service.addAuthor(dto);
		});

	}

	@Test
	void create_whenCorrectDto_thenCreateAuthor() throws AuthorServiceException {
		AuthorSaveDto dto = AuthorSaveDto.builder()
				.name("author-name")
				.surname("author-surname")
				.build();

		Long addAuthor = service.addAuthor(dto);
		Assertions.assertNotNull(addAuthor);
	}

}
