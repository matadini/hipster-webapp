package pl.matadini.hipsterwebapp.context.admin;

import javax.persistence.EntityManagerFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminFacade {

	public static SparkController create(EntityManagerFactory entityManagerFactory) {
		return AdminControllerImpl.builder()
				.entityManagerFactory(entityManagerFactory)
				.build();
	}

}