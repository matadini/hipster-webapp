package pl.matadini.hipsterwebapp.context.blog.author;

import javax.persistence.EntityManagerFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorServiceFactory {

	static AuthorService create(EntityManagerFactory entityManagerFactory) {
		return AuthorServiceImp.builder().build();
	}
}