package pl.matadini.hipsterwebapp.context.person;

import javax.persistence.EntityManagerFactory;

import freemarker.template.Configuration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFacade {

	public static SparkController create(Configuration configuration, EntityManagerFactory entityManagerFactory) {
		
		return PersonControllerImpl.builder()
				.configuration(configuration)
				.entityManagerFactory(entityManagerFactory)
				.build();
	}

}