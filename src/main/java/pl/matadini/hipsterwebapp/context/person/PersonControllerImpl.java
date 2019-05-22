package pl.matadini.hipsterwebapp.context.person;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.person.dto.PersonCreateDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class PersonControllerImpl implements PersonController {

	Configuration configuration;
	EntityManagerFactory entityManagerFactory;

	@Override
	public void initialize(Service service) {
		service.get("/person", this::home);

		service.get("/person/create", this::getCreate);
		service.post("/person/create", this::postCreate);

		service.get("/person/get-all", this::getGetAll);

		service.get("/person/delete/:personId", this::delete); // route);
	}

	@Override
	public Object postCreate(Request request, Response response) {

		try {

			/*
			 * Validate data and create new person
			 */
			PersonCreateDto dto = PersonCreateDto.builder()
					.name(request.queryParams("name"))
					.email(request.queryParams("email"))
					.surname(request.queryParams("surname"))
					.build();

			PersonService service = PersonServiceFactory.create(entityManagerFactory);
			Long personId = service.create(dto);

			/*
			 * Prepare and return view
			 */
			Map<String, Object> map = Maps.newHashMap();
			map.put("info", "Created user ID: " + personId);

			Template template = configuration.getTemplate("templates/general/action-success.ftl");
			template.process(map, response.raw().getWriter());

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object read(Request request, Response response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object edit(Request request, Response response) {

		try {

		} catch (Exception ex) {

		}
		return response;
	}

	@Override
	public Object delete(Request request, Response response) {

		try {

			Long personId = Long.valueOf(request.params("personId"));

			PersonService service = PersonServiceFactory.create(entityManagerFactory);
			service.delete(personId);

			response.redirect("/person/get-all");

		} catch (Exception ex) {

		}

		return response;
	}

	@Override
	public Object getGetAll(Request request, Response response) {
		try {

			PersonService service = PersonServiceFactory.create(entityManagerFactory);
			List<PersonDto> all = service.getAll();

			Map<Object, Object> newHashMap = Maps.newHashMap();
			newHashMap.put("persons", all);
			newHashMap.put("info", all.isEmpty() ? "No persons in database" : "Persons:");

			Template template = configuration.getTemplate("templates/person/get-all.ftl");
			template.process(newHashMap, response.raw().getWriter());

		} catch (Exception ex) {
			Logger.error(ex);
		}
		return response;
	}

	@Override
	public Object getCreate(Request request, Response response) {
		try {

			Template template = configuration.getTemplate("templates/person/create.ftl");
			template.process(null, response.raw().getWriter());

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object home(Request request, Response response) {
		try {

			Template template = configuration.getTemplate("templates/person/home.ftl");
			template.process(null, response.raw().getWriter());

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

}