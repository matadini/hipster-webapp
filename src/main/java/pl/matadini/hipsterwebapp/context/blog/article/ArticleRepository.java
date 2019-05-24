package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pl.matadini.hipsterwebapp.shared.jpa.JpaRepository;

interface ArticleRepository extends JpaRepository<Article, Long> {

	static ArticleRepository create(EntityManager entityManager) {
		return new ArticleRepositoryImpl(entityManager);
	}
}