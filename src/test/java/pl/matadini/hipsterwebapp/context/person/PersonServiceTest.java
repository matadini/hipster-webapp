package pl.matadini.hipsterwebapp.context.person;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonSaveDto;
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
	void testCreate() throws PersonServiceException {
		// given
		PersonSaveDto build = PersonTestSampleFactory.createPersonSaveDtoSampleJanuszNosacz();

		// when
		Long create = service.create(build);

		// then
		Assertions.assertNotNull(create);
	}

	@Test
	void testUpdate() throws PersonServiceException {

		// given
		PersonSaveDto dto = PersonTestSampleFactory.createPersonSaveDtoSampleJanuszNosacz();
		Long personId = service.create(dto);

		// when
		PersonSaveDto dtoUpdate = PersonTestSampleFactory.createPersonSaveDtoSampleJanuszNosaczUpdate();
		service.update(personId, dtoUpdate);

		// then
		Optional<PersonDto> findById = service.findById(personId);
		Assertions.assertTrue(findById.isPresent());

		PersonDto personDto = findById.get();
		PersonSaveDto saveDto = PersonUtil.personDtoToPersonSaveDto().apply(personDto);
		Assertions.assertTrue(saveDto.equals(dtoUpdate));
		Assertions.assertFalse(saveDto.equals(dto));

	}
}
