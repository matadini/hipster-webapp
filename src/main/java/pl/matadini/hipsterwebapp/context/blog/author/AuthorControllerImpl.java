package pl.matadini.hipsterwebapp.context.blog.author;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;
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

			PrintWriter writer = response.raw().getWriter();

			Template template = configuration.getTemplate("templates/blog/author/home.ftl");
			template.process(null, writer);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createGet(Request request, Response response) {
		try {

			PrintWriter writer = response.raw().getWriter();

			Template template = configuration.getTemplate("templates/blog/author/create.ftl");
			template.process(null, writer);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createPost(Request request, Response response) {
		try {

			/*
			 * Parse data from client 
			 */

			String queryParams = request.queryParams("birth-date");
			String queryParams2 = request.queryParams("name");
			String queryParams3 = request.queryParams("email");
			String queryParams4 = request.queryParams("surname");
			
			AuthorSaveDto dto = AuthorSaveDto.builder()
					.name(queryParams2)
					.email(queryParams3)
					.surname(queryParams4)
					.birthDate(LocalDate.parse(queryParams))
					.build();

			AuthorService service = AuthorServiceFactory.create(entityManagerFactory);
			Long addAuthor = service.addAuthor(dto);

			/*
			 * Prepare view
			 */
			Map<String, Object> map = Maps.newHashMap();
			map.put("info", "Created user ID: " + addAuthor);
			map.put("link", "/author/"); 
			
			Template template = configuration.getTemplate("templates/general/action-success.ftl");
			template.process(map, response.raw().getWriter());
			
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

			PrintWriter writer = response.raw().getWriter();

			Template template = configuration.getTemplate("templates/blog/author/get-all.ftl");
			template.process(data, writer);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

}