package pl.matadini.hipsterwebapp.context.user;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;
import spark.Response;

interface UserController extends SparkController {

	Object home(Request request, Response response);
}
