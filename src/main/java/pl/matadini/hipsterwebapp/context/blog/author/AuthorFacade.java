package pl.matadini.hipsterwebapp.context.blog.author;

import javax.persistence.EntityManagerFactory;

import freemarker.template.Configuration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorFacade {

	public static SparkController create(EntityManagerFactory entityManagerFactory, Configuration configuration) {
		
		return AuthorControllerImpl.builder()
				.configuration(configuration)
				.entityManagerFactory(entityManagerFactory)
				.build();
	}

}