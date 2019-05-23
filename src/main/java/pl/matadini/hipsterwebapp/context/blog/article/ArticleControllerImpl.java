package pl.matadini.hipsterwebapp.context.blog.article;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleAuthorDto;
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
	}

	@Override
	public Object home(Request request, Response response) {
		try {
			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/home.ftl");
			template.process(null, writer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	@Override
	public Object getAll(Request request, Response response) {

		try {
//			PrintWriter writer = response.raw().getWriter();
//			Template template = configuration.getTemplate("templates/blog/article/get-all.ftl");
//			template.process(null, writer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	@Override
	public Object createGet(Request request, Response response) {
		try {

			ArticleService service = new ArticleServiceAdapter() {
				@Override
				public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {

					ArticleAuthorDto item0 = new ArticleAuthorDto(1L, "Janusz", "Nosacz");
					ArticleAuthorDto item1 = new ArticleAuthorDto(2L, "Samosiad", "Zlodziej");
					ArticleAuthorDto item2 = new ArticleAuthorDto(3L, "Sebastian", "Dynamiczny");

					return Lists.newArrayList(item0, item1, item2);
				}
			};
			List<ArticleAuthorDto> articleAuthors = service.getArticleAuthors();

			Map<String, Object> data = Maps.newHashMap();
			data.put("authors", articleAuthors);

			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/create.ftl");
			template.process(data, writer);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	@Override
	public Object createPost(Request request, Response response) {
		// TODO Auto-generated method stub
		return null;
	}

}