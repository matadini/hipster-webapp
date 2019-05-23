package pl.matadini.hipsterwebapp.context.person;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;
import spark.Response;

interface PersonController extends SparkController {

	Object home(Request request, Response response);

	Object postCreate(Request request, Response response);

	Object getCreate(Request request, Response response);

	Object read(Request request, Response response);

	Object getEdit(Request request, Response response);

	Object postEdit(Request request, Response response);

	Object delete(Request request, Response response);

	Object getGetAll(Request request, Response response);

}
