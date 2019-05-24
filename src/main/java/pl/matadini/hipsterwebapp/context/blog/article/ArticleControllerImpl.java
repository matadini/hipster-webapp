package pl.matadini.hipsterwebapp.context.blog.article;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class ArticleControllerImpl implements ArticleController {



	Configuration configuration;
	EntityManagerFactory entityManagerFactory;

	@Override
	public void initialize(Service service) {

		service.get("/article/", this::home);
		service.get("/article/create", this::createGet);
		service.get("/article/get-all", this::getAll);

		service.post("/article/create", this::createPost);
	}

	@Override
	public Object home(Request request, Response response) {
		try {
			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/home.ftl");
			template.process(null, writer);
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object getAll(Request request, Response response) {

		try {

			/*
			 * Data
			 */
			ArticleService service = ArticleServiceStub.createGetAllStub();
			List<ArticleAuthorWithArticlesDto> authorsWithArticles = service.getAuthorsWithArticles();

			/*
			 * View
			 */
			Map<String, Object> map = Maps.newHashMap();
			map.put("authors", authorsWithArticles);
			map.put("info", "message from server");

			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/get-all.ftl");
			template.process(map, writer);
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createGet(Request request, Response response) {
		try {

			ArticleService service = ArticleServiceStub.createGetArticleAuthors();
			List<ArticleAuthorDto> articleAuthors = service.getArticleAuthors();

			Map<String, Object> data = Maps.newHashMap();
			data.put("authors", articleAuthors);

			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/create.ftl");
			template.process(data, writer);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createPost(Request request, Response response) {

		try {

			String title = request.queryParams("title");
			String content = request.queryParams("content");
			Long articleAuthorId = Long.valueOf(request.queryParams("authors-id"));

			ArticleSaveDto data = ArticleSaveDto.builder()
					.title(title)
					.content(content)
					.articleAuthorId(articleAuthorId)
					.build();

			ArticleService service = ArticleServiceFactory.create(entityManagerFactory);
			service.createArticle(articleAuthorId, data);

			Logger.info("{} {} {}", title, content, articleAuthorId);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

}