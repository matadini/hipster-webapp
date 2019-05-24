package pl.matadini.hipsterwebapp.context.admin;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;
import spark.Response;

interface AdminController extends SparkController {

	Object healhtcheck(Request request, Response response);
}