package pl.matadini.hipsterwebapp.context.blog.author;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;

interface AuthorController extends SparkController {

	Object home(Request request, spark.Response response);
	
	Object createGet(Request request, spark.Response response);

	Object createPost(Request request, spark.Response response);
	
	Object getAll(Request request, spark.Response response);
}
