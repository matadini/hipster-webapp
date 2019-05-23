package pl.matadini.hipsterwebapp.context.person;

import java.util.Optional;

import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonSaveDto;

interface PersonService {

	Long create(PersonSaveDto data) throws PersonServiceException;

	java.util.List<PersonDto> getAll() throws PersonServiceException;

	void delete(Long personId) throws PersonServiceException;
	
	void update(Long personId, PersonSaveDto data) throws PersonServiceException;

	Optional<PersonDto> findById(Long personId) throws PersonServiceException;

}
