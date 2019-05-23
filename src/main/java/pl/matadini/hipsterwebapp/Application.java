package pl.matadini.hipsterwebapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.google.common.collect.Lists;

import freemarker.template.Configuration;
import freemarker.template.Version;
import pl.matadini.hipsterwebapp.context.person.PersonFacade;
import pl.matadini.hipsterwebapp.context.user.UserFacade;
import pl.matadini.hipsterwebapp.shared.jpa.EntityManagerFactoryProvider;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Service;

public class Application {

	public static void main(String[] args) {

		final Configuration configuration = new Configuration(new Version(2, 3, 0));
		configuration.setClassForTemplateLoading(Application.class, "/");

		EntityManagerFactory entityManagerFactoryH2 = EntityManagerFactoryProvider.createEntityManagerFactoryH2();

		Service service = Service.ignite().port(8080);

		List<SparkController> controllers = Lists.newArrayList(
				UserFacade.create(),
				PersonFacade.create(configuration, entityManagerFactoryH2));
		controllers.forEach(item -> item.initialize(service));

	}
}
