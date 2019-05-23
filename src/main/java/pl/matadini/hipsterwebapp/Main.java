package pl.matadini.hipsterwebapp;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.google.common.collect.Lists;

import freemarker.template.Configuration;
import pl.matadini.hipsterwebapp.context.blog.article.ArticleFacade;
import pl.matadini.hipsterwebapp.context.blog.author.AuthorFacade;
import pl.matadini.hipsterwebapp.context.person.PersonFacade;
import pl.matadini.hipsterwebapp.shared.freemarker.FreemarkerUtil;
import pl.matadini.hipsterwebapp.shared.jpa.EntityManagerFactoryProvider;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Service;

public class Main {

	public static void main(String[] args) {

		Configuration configuration = FreemarkerUtil.getFreemarkerConfiguration();
		EntityManagerFactory entityManagerFactoryH2 = EntityManagerFactoryProvider.createEntityManagerFactoryH2();

		Service service = Service.ignite().port(8080);

		List<SparkController> controllers = Lists.newArrayList(
				ArticleFacade.create(entityManagerFactoryH2, configuration),
				AuthorFacade.create(entityManagerFactoryH2, configuration),
				PersonFacade.create(entityManagerFactoryH2, configuration));
		controllers.forEach(item -> item.initialize(service));

	}


}
