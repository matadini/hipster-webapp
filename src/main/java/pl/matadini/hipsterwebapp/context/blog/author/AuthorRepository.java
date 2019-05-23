package pl.matadini.hipsterwebapp.context.blog.author;

import javax.persistence.EntityManager;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	static AuthorRepository create(EntityManager entityManager) {
		return new AuthorRepositoryImpl(entityManager);
	}
}
