package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.EntityManager;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

interface ArticleRepository extends JpaRepository<Article, Long> {

	static ArticleRepository create(EntityManager entityManager) {
		return new ArticleRepositoryImpl(entityManager);
	}
}