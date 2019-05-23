package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;

import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleSaveDto;

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

}