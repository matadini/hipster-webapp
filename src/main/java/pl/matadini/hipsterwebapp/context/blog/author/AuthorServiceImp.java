package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;

@Builder
class AuthorServiceImp implements AuthorService {

	Validator validator;
	ModelMapper modelMapper;
	AuthorRepository authorRepository;

	@Override
	public Long addAuthor(AuthorSaveDto data) throws AuthorServiceException {

		Set<ConstraintViolation<AuthorSaveDto>> validate = validator.validate(data);
		if (!validate.isEmpty()) {
			throw new AuthorServiceException("Invalid input data: \n" + validate);
		}

		Author entity = modelMapper.map(data, Author.class);
		Author save = authorRepository.save(entity);
		return save.getAuthorId();
	}

	@Override
	public List<AuthorDto> getAll() throws AuthorServiceException {
		Function<? super Author, ? extends AuthorDto> authorToAuthorDto = AuthorUtil.authorToAuthorDto();
		return authorRepository.findAll()
				.stream()
				.map(authorToAuthorDto)
				.collect(Collectors.toList());
	}

}