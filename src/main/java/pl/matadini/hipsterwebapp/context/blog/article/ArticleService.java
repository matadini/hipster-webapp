package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;

import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

public interface ArticleService {

	Long createArticle(Long articleAuthorId, ArticleSaveDto data) throws ArticleServiceException;

	List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException;

	List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException;
}
