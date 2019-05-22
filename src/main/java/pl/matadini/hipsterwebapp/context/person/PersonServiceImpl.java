package pl.matadini.hipsterwebapp.context.person;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.person.dto.PersonCreateDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;

@Builder
class PersonServiceImpl implements PersonService {

	Validator validator;
	ModelMapper modelMapper;
	PersonRepository personRepository;

	@Override
	public Long create(PersonCreateDto dto) throws PersonServiceException {

		Set<ConstraintViolation<PersonCreateDto>> validate = validator.validate(dto);
		if (!validate.isEmpty()) {
			throw new PersonServiceException("Incorrect input data");
		}

		Person entity = modelMapper.map(dto, Person.class);
		return personRepository.save(entity).getPersonId();
	}

	@Override
	public List<PersonDto> getAll() throws PersonServiceException {
		return personRepository.findAll()
				.stream()
				.map(personToPersonDto())
				.collect(Collectors.toList());
	}

	private Function<? super Person, ? extends PersonDto> personToPersonDto() {
		return x -> PersonDto.builder()
				.email(x.getEmail())
				.name(x.getName())
				.surname(x.getSurname())
				.personId(x.getPersonId())
				.build();
	}

}