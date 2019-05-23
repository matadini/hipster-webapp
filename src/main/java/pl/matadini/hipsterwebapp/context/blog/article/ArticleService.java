package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;

import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleSaveDto;

interface ArticleService {

	Long createArticle(Long articleAuthorId, ArticleSaveDto data) throws ArticleServiceException;

	List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException;
}
