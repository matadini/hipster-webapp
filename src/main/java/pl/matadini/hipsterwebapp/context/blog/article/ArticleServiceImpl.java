package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ArticleUtil {
	
}

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
	public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException {

		List<ArticleAuthor> findAll = articleAuthorRepository.findAll();
		return findAll.stream()
				.map(x -> {

					List<ArticleDto> collect = x.getArticles().stream()
							.map(y -> ArticleDto.builder().build())
							.collect(Collectors.toList());

					return ArticleAuthorWithArticlesDto.builder()
							.name(x.getName())
							.surname(x.getSurname())
							.articles(collect)
							.articleAuthorId(x.getArticleAuthorId())
							.build();
				})
				.collect(Collectors.toList());
	}

}