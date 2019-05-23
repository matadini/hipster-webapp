package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class AuthorControllerImpl implements AuthorController {

	Configuration configuration;
	EntityManagerFactory entityManagerFactory;

	@Override
	public void initialize(Service service) {

		service.get("/author/", this::home);
		service.get("/author/get-all", this::getAll);
		service.get("/author/create", this::createGet);

		service.post("/author/create", this::createPost);
	}

	@Override
	public Object home(Request request, Response response) {

		try {
			Template template = configuration.getTemplate("templates/blog/author/home.ftl");
			template.process(null, response.raw().getWriter());

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createGet(Request request, Response response) {
		try {
			Template template = configuration.getTemplate("templates/blog/author/create.ftl");
			template.process(null, response.raw().getWriter());
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createPost(Request request, Response response) {
		try {

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object getAll(Request request, Response response) {
		try {

			AuthorService service = AuthorServiceFactory.create(entityManagerFactory);
			List<AuthorDto> all = service.getAll();

			Map<String, Object> data = Maps.newHashMap();
			data.put("authors", all);
			data.put("info", all.isEmpty() ? "No authors in database" : "Author list");

			Template template = configuration.getTemplate("templates/blog/author/get-all.ftl");
			template.process(null, response.raw().getWriter());
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

}