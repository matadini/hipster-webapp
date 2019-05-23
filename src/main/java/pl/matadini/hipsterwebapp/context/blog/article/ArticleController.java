package pl.matadini.hipsterwebapp.context.blog.article;

import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;
import spark.Response;

interface ArticleController extends SparkController {

	Object home(Request request, Response response);
	
	Object getAll(Request request, Response response);
	
	Object createGet(Request request, Response response);
	
	Object createPost(Request request, Response response);
}
