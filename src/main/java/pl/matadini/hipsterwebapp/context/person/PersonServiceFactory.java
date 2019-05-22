package pl.matadini.hipsterwebapp.context.person;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.modelmapper.ModelMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PersonServiceFactory {

	static PersonService create(EntityManagerFactory entityManagerFactory) {

		ModelMapper modelMapper = new ModelMapper();

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		PersonRepository personRepository = PersonRepository.create(entityManagerFactory.createEntityManager());
		
		return PersonServiceImpl.builder()
				.validator(validator)
				.modelMapper(modelMapper)
				.personRepository(personRepository)
				.build();
	}

}