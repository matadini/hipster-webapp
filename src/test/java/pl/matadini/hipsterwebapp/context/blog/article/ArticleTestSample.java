package pl.matadini.hipsterwebapp.context.blog.article;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ArticleTestSample {
	
	public static AuthorSaveDto createAuthorSaveDto0() {
		return AuthorSaveDto.builder().birthDate(LocalDate.now()).name("name-0").surname("surname-0").build();
	}

	public static AuthorSaveDto createAuthorSaveDto1() {
		return AuthorSaveDto.builder().birthDate(LocalDate.now()).name("name-1").surname("surname-1").build();
	}
}