package pl.matadini.hipsterwebapp.context.blog.author;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorTestSampleFactory {

	static Author createStandardEntity() {
		return new Author("name", "surname", LocalDate.now());
	}

	static AuthorSaveDto createInvalidSaveDto() {
		return AuthorSaveDto.builder()
				.name("author-name")
				.build();
	}
	
	static AuthorSaveDto createStandardSaveDto() {
		return AuthorSaveDto.builder()
				.name("author-name")
				.surname("author-surname")
				.birthDate(LocalDate.now())
				.build();
	}
}