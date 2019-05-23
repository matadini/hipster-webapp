package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.EntityManagerFactory;

import freemarker.template.Configuration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleFacade {

	public static SparkController create(EntityManagerFactory entityManagerFactory, Configuration configuration) {
		
		return ArticleControllerImpl.builder()
				.configuration(configuration)
				.entityManagerFactory(entityManagerFactory)
				.build();
	}
}