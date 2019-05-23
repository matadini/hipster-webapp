package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleSaveDto;

@Builder
class ArticleServiceImpl implements ArticleService {

	Validator validator;
	ModelMapper modelMapper;
	ArticleRepository articleRepository;
	ArticleAuthorRepository articleAuthorRepository;

	@Override
	public Long createArticle(Long articleAuthorId, ArticleSaveDto data) throws ArticleServiceException {

		Set<ConstraintViolation<ArticleSaveDto>> validate = validator.validate(data);
		if (!validate.isEmpty()) {
			throw new ArticleServiceException("Invalid input data: \n" + validate);
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleAuthor> getArticleAuthors() throws ArticleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}