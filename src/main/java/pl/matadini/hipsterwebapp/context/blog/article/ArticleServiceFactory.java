package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.EntityManagerFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ArticleServiceFactory {
	static ArticleService create(EntityManagerFactory entityManagerFactory) {
		return ArticleServiceImpl.builder().build();
	}
}