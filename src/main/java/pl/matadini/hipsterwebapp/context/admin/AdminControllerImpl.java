package pl.matadini.hipsterwebapp.context.admin;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.admin.AdminControllerImpl.AdminControllerImplBuilder;
import pl.matadini.hipsterwebapp.context.blog.article.ArticleService;
import pl.matadini.hipsterwebapp.context.blog.article.ArticleServiceFactory;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class AdminControllerImpl implements AdminController {

	EntityManagerFactory entityManagerFactory;

	@Override
	public void initialize(Service service) {
		service.get("/healhtcheck", this::healhtcheck);
	}

	@Override
	public Object healhtcheck(Request request, Response response) {
		
		try {
			ArticleService create = ArticleServiceFactory.create(entityManagerFactory);
			List<ArticleAuthorWithArticlesDto> authorsWithArticles = create.getAuthorsWithArticles();
			Logger.info(authorsWithArticles);
		} catch (Exception ex) {
			Logger.error(ex);
		}
		return response;
	}

}