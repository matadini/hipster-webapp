package pl.matadini.hipsterwebapp.context.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.shared.spark.SparkController;
import spark.Request;
import spark.Response;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFacade {

	public static SparkController create() {
		return UserControllerImpl.builder()
				.build();
	}

}
