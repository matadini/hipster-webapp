package pl.matadini.hipsterwebapp.context.person;

import spark.Response;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;

interface PersonController extends SparkController {

	Object home(Request request, Response response);

	Object postCreate(Request request, Response response);

	Object getCreate(Request request, Response response);

	
	
	Object read(Request request, Response response);

	Object edit(Request request, Response response);

	Object delete(Request request, Response response);

	Object getGetAll(Request request, Response response);

}
