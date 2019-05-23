package pl.matadini.hipsterwebapp.shared.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Version;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.Main;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FreemarkerUtil {
	public static Configuration getFreemarkerConfiguration() {
		final Configuration configuration = new Configuration(new Version(2, 3, 0));
		configuration.setClassForTemplateLoading(Main.class, "/");
		return configuration;
	}
}