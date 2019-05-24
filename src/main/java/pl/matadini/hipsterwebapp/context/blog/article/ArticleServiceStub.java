package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ArticleServiceStub {

	static ArticleService createGetArticleAuthors() {
		return new ArticleServiceAdapter() {
			@Override
			public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {

				ArticleAuthorDto item0 = new ArticleAuthorDto(1L, "Janusz", "Nosacz");
				ArticleAuthorDto item1 = new ArticleAuthorDto(2L, "Samosiad", "Zlodziej");
				ArticleAuthorDto item2 = new ArticleAuthorDto(3L, "Sebastian", "Dynamiczny");

				return Lists.newArrayList(item0, item1, item2);
			}
		};
	}
	static ArticleService createGetAllStub() {
		return new ArticleServiceAdapter() {
			@Override
			public List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException {

				List<ArticleAuthorWithArticlesDto> toReturn = Lists.newArrayList();

				int authorCount = 3;
				int articlePerAuthorCount = 5;
				for (int i = 0; i < authorCount; ++i) {

					List<ArticleDto> articleDtos = Lists.newArrayList(); // ();
					for (int j = 0; j < articlePerAuthorCount; ++j) {

						Long articleId = Long.valueOf(j * 10 + i);
						ArticleDto build = ArticleDto.builder()
								.title("Article: " + articleId + " title")
								.content(ArticleUtil.createLargeText())
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
	}
}