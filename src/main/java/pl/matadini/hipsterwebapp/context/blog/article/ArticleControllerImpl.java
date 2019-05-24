package pl.matadini.hipsterwebapp.context.blog.article;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManagerFactory;

import org.pmw.tinylog.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;
import spark.Request;
import spark.Response;
import spark.Service;

@Builder
class ArticleControllerImpl implements ArticleController {

	private static String createLargeText() {
		return "Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. "
				+ "Został po raz pierwszy użyty w XV w. przez nieznanego drukarza do wypełnienia tekstem próbnej książki. "
				+ "Pięć wieków później zaczął być używany przemyśle elektronicznym, pozostając praktycznie niezmienionym. "
				+ "Spopularyzował się w latach 60. XX w. wraz z publikacją arkuszy Letrasetu, zawierających fragmenty "
				+ "Lorem Ipsum, a ostatnio z zawierającym różne wersje Lorem Ipsum oprogramowaniem przeznaczonym do "
				+ "realizacji druków na komputerach osobistych, jak Aldus PageMaker";
	}

	Configuration configuration;
	EntityManagerFactory entityManagerFactory;

	@Override
	public void initialize(Service service) {
		service.get("/article/", this::home);
		service.get("/article/create", this::createGet);
		service.get("/article/get-all", this::getAll);
		service.post("/article/create", this::createPost);
	}

	@Override
	public Object home(Request request, Response response) {
		try {
			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/home.ftl");
			template.process(null, writer);
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	
	
	
	@Override
	public Object getAll(Request request, Response response) {

		try {

			/*
			 * Data
			 */
			ArticleService service = new ArticleServiceAdapter() {
				@Override
				public List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException {

					List<ArticleAuthorWithArticlesDto> toReturn = Lists.newArrayList();

					int authorCount = 3;
					int articlePerAuthorCount = 5;
					for (int i = 0; i < authorCount; ++i) {

						List<ArticleDto> articleDtos = Lists.newArrayList(); //();
						for (int j = 0; j < articlePerAuthorCount; ++j) {

							Long articleId = Long.valueOf( j * 10 + i);
							ArticleDto build = ArticleDto.builder()
									.title("Article: " + articleId + " title")
									.content(createLargeText())
									.articleId(articleId)
									.viewUUID(UUID.randomUUID().toString())
									.build();
							articleDtos.add(build);
						}
						

						Long authorId = Long.valueOf(i);
						String name = "author-name-" + i;
						String surname = "author-surname-" + i;

						ArticleAuthorWithArticlesDto build = ArticleAuthorWithArticlesDto.builder()
								.name(name)
								.surname(surname)
								.articles(articleDtos)
								.viewUUID(UUID.randomUUID().toString())
								.articleAuthorId(authorId)
								.build();
						toReturn.add(build);

					}

					return toReturn;

				}
			};
			List<ArticleAuthorWithArticlesDto> authorsWithArticles = service.getAuthorsWithArticles();

			/*
			 * View
			 */
			Map<String, Object> map = Maps.newHashMap();
			map.put("authors", authorsWithArticles);
			map.put("info", "message from server");

			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/get-all.ftl");
			template.process(map, writer);
		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createGet(Request request, Response response) {
		try {

			ArticleService service = new ArticleServiceAdapter() {
				@Override
				public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {

					ArticleAuthorDto item0 = new ArticleAuthorDto(1L, "Janusz", "Nosacz");
					ArticleAuthorDto item1 = new ArticleAuthorDto(2L, "Samosiad", "Zlodziej");
					ArticleAuthorDto item2 = new ArticleAuthorDto(3L, "Sebastian", "Dynamiczny");

					return Lists.newArrayList(item0, item1, item2);
				}
			};
			List<ArticleAuthorDto> articleAuthors = service.getArticleAuthors();

			Map<String, Object> data = Maps.newHashMap();
			data.put("authors", articleAuthors);

			PrintWriter writer = response.raw().getWriter();
			Template template = configuration.getTemplate("templates/blog/article/create.ftl");
			template.process(data, writer);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

	@Override
	public Object createPost(Request request, Response response) {

		try {

			String title = request.queryParams("title");
			String content = request.queryParams("content");
			Long articleAuthorId = Long.valueOf(request.queryParams("authors-id"));

			ArticleSaveDto data = ArticleSaveDto.builder()
					.title(title)
					.content(content)
					.articleAuthorId(articleAuthorId)
					.build();

			ArticleService service = ArticleServiceFactory.create(entityManagerFactory);
			service.createArticle(articleAuthorId, data);

			Logger.info("{} {} {}", title, content, articleAuthorId);

		} catch (Exception e) {
			Logger.error(e);
		}
		return response;
	}

}