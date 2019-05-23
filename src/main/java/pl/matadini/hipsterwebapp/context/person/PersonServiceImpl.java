package pl.matadini.hipsterwebapp.context.person;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.person.dto.PersonSaveDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;

@Builder
class PersonServiceImpl implements PersonService {

	Validator validator;
	ModelMapper modelMapper;
	PersonRepository personRepository;

	@Override
	public Long create(PersonSaveDto dto) throws PersonServiceException {

		Set<ConstraintViolation<PersonSaveDto>> validate = validator.validate(dto);
		if (!validate.isEmpty()) {
			throw new PersonServiceException("Incorrect input data");
		}

		Person entity = modelMapper.map(dto, Person.class);
		Person save = personRepository.save(entity);
		return save.getPersonId();
	}

	@Override
	public List<PersonDto> getAll() throws PersonServiceException {
		return personRepository.findAll()
				.stream()
				.map(PersonUtil.personToPersonDto())
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long personId) throws PersonServiceException {

		Optional<Person> findById = personRepository.findById(personId);
		Person entity = findById.get();
		personRepository.delete(entity);
	}

	@Override
	public Optional<PersonDto> findById(Long personId) throws PersonServiceException {

		Optional<Person> findById = personRepository.findById(personId);
		return findById.isPresent() ? Optional.of(PersonUtil.personToPersonDto().apply(findById.get()))
				: Optional.empty();
	}

	@Override
	public void update(Long personId, PersonSaveDto data) throws PersonServiceException {

		Person entity = modelMapper.map(data, Person.class);
		entity.setPersonId(personId);
		personRepository.save(entity);
	}

}