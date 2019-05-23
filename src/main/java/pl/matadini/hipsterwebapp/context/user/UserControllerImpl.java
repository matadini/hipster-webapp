package pl.matadini.hipsterwebapp.context.user;

import org.pmw.tinylog.Logger;

import com.google.gson.Gson;

import lombok.Builder;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class UserControllerImpl implements UserController {

	Gson gson;

	@Override
	public void initialize(Service service) {

		service.get("/user/", this::home);
	}

	@Override
	public Object home(Request request, Response response) {
		// TODO Auto-generated method stub
		return "Hello";
	}

}