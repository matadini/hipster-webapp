package pl.matadini.hipsterwebapp.context.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.context.person.dto.PersonCreateDto;
import pl.matadini.hipsterwebapp.shared.test.H2Test;

class PersonServiceTest extends H2Test {

	PersonService service;

	@BeforeEach
	@Override
	protected void beforeEach() {
		super.beforeEach();
		service = PersonServiceFactory.create(entityManagerFactory);
	}

	@Test
	void test() throws PersonServiceException {
		// given
		PersonCreateDto build = PersonCreateDto.builder()
				.name("Janusz")
				.surname("Nosacz")
				.email("xxx@gmail.com")
				.build();
		
		// when
		Long create = service.create(build);
		
		// then 
		Assertions.assertNotNull(create);
	}

}
