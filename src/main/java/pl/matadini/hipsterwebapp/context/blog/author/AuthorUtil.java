package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorUtil {

	static Function<? super Author, ? extends AuthorDto> authorToAuthorDto() {
		return x -> AuthorDto.builder()
				.name(x.getName())
				.email(x.getEmail())
				.surname(x.getSurname())
				.authorId(x.getAuthorId())
				.birthDate(x.getBirthDate())
				.build();
	}
}