package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;

import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

class ArticleServiceAdapter implements ArticleService {

	@Override
	public Long createArticle(Long articleAuthorId, ArticleSaveDto data) throws ArticleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}