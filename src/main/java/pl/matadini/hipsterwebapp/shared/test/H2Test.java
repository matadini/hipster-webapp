package pl.matadini.hipsterwebapp.shared.test;

import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import pl.matadini.hipsterwebapp.shared.jpa.EntityManagerFactoryProvider;

public class H2Test {

	protected EntityManagerFactory entityManagerFactory;

	@BeforeEach
	protected void beforeEach() {
		entityManagerFactory = EntityManagerFactoryProvider.createEntityManagerFactoryH2();
	}

	@AfterEach
	protected void afterEach() {
		entityManagerFactory.close();
	}

}
