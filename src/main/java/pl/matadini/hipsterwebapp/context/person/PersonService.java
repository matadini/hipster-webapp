package pl.matadini.hipsterwebapp.context.person;

import java.awt.List;

import pl.matadini.hipsterwebapp.context.person.dto.PersonCreateDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;


interface PersonService {

	Long create(PersonCreateDto dto) throws PersonServiceException;

	java.util.List<PersonDto> getAll() throws PersonServiceException;
}
