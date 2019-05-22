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

		service.delete("/person", this::delete); // route);
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
			StringWriter out = new StringWriter();

			Map<String, Object> map = Maps.newHashMap();
			map.put("info", "Created user ID: " + personId);

			Template template = configuration.getTemplate("templates/general/action-success.ftl");
			template.process(map, out);

			return out;

		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}

	@Override
	public Object read(Request request, Response response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Request request, Response response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delete(Request request, Response response) {

		Logger.info(request.queryParams());
		return null;
	}

	@Override
	public Object getGetAll(Request request, Response response) {
		try {

			PersonService service = PersonServiceFactory.create(entityManagerFactory);
			List<PersonDto> all = service.getAll();

			Map<Object, Object> newHashMap = Maps.newHashMap();
			newHashMap.put("persons", all);
			newHashMap.put("info", all.isEmpty() ? "No persons in database" : "Persons:");

			StringWriter out = new StringWriter();
			Template template = configuration.getTemplate("templates/person/get-all.ftl");
			template.process(newHashMap, out);

			return out;
		} catch (Exception ex) {
			Logger.error(ex);
		}
		return null;
	}

	@Override
	public Object getCreate(Request request, Response response) {
		try {
			StringWriter writer = new StringWriter();
			Template template = configuration.getTemplate("templates/person/create.ftl");
			template.process(null, writer);
			return writer;
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}

	@Override
	public Object home(Request request, Response response) {
		try {
			StringWriter writer = new StringWriter();
			Template template = configuration.getTemplate("templates/person/home.ftl");
			template.process(null, writer);
			return writer;
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}

}