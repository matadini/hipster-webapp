package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ArticleUtil {

	static Function<? super Article, ? extends ArticleDto> articleToArticleDto() {
		return x -> ArticleDto.builder()
				.title(x.getTitle())
				.content(x.getContent())
				.articleId(x.getArticleId())
				.viewUUID(UUID.randomUUID().toString())
				.build();
	}

	static Function<? super ArticleAuthor, ? extends ArticleAuthorDto> articleAuthorToArticleAuthorDto() {
		return x -> {
			return ArticleAuthorDto.builder()
					.articleAuthorId(x.getArticleAuthorId())
					.name(x.getName())
					.surname(x.getSurname())
					.build();
		};
	}
	
	static Function<? super ArticleAuthor, ? extends ArticleAuthorWithArticlesDto> authorToAuthorWithArticles() {

		Function<? super Article, ? extends ArticleDto> mapperArticles = ArticleUtil.articleToArticleDto();

		return x -> {

			List<ArticleDto> collect = x.getArticles().stream()
					.map(mapperArticles)
					.collect(Collectors.toList());

			return ArticleAuthorWithArticlesDto.builder()
					.name(x.getName())
					.surname(x.getSurname())
					.articles(collect)
					.articleAuthorId(x.getArticleAuthorId())
					.build();
		};
	}
	
	public static String createLargeText() {
		return "Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. "
				+ "Został po raz pierwszy użyty w XV w. przez nieznanego drukarza do wypełnienia tekstem próbnej książki. "
				+ "Pięć wieków później zaczął być używany przemyśle elektronicznym, pozostając praktycznie niezmienionym. "
				+ "Spopularyzował się w latach 60. XX w. wraz z publikacją arkuszy Letrasetu, zawierających fragmenty "
				+ "Lorem Ipsum, a ostatnio z zawierającym różne wersje Lorem Ipsum oprogramowaniem przeznaczonym do "
				+ "realizacji druków na komputerach osobistych, jak Aldus PageMaker";
	}
}