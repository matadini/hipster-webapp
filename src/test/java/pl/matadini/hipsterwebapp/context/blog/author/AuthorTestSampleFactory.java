package pl.matadini.hipsterwebapp.context.blog.author;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorTestSampleFactory {

	static Author createStandardEntity() {
		return new Author("name", "surname", LocalDate.now());
	}
}