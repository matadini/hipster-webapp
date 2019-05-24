package pl.matadini.hipsterwebapp.context.blog.author;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.modelmapper.ModelMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorServiceFactory {

	public static AuthorService create(EntityManagerFactory entityManagerFactory) {

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		ModelMapper modelMapper = new ModelMapper();

		AuthorRepository repository = AuthorRepository.create(entityManagerFactory.createEntityManager());

		return AuthorServiceImp.builder()
				.validator(validator)
				.modelMapper(modelMapper)
				.authorRepository(repository)
				.build();
	}
}