package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.EntityManager;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

interface ArticleAuthorRepository extends JpaRepository<ArticleAuthor, Long> {

	static ArticleAuthorRepository create(EntityManager entityManager) {
		return new ArticleAuthorRepositoryImpl(entityManager);
	}
}