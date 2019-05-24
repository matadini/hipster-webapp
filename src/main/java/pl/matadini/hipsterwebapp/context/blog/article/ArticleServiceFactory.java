package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.function.Function;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.modelmapper.ModelMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleServiceFactory {

	public static ArticleService create(EntityManagerFactory entityManagerFactory) {

		ValidatorFactory buildDefaultValidatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = buildDefaultValidatorFactory.getValidator();
		ModelMapper modelMapper = ArticleBean.modelMapper(); 

		ArticleRepository articleRepository = ArticleRepository.create(entityManagerFactory.createEntityManager());
		ArticleAuthorRepository articleAuthorRepository = ArticleAuthorRepository.create(entityManagerFactory.createEntityManager());

		Function<? super ArticleAuthor, ? extends ArticleAuthorDto> mapper = ArticleUtil.articleAuthorToArticleAuthorDto();

		return ArticleServiceImpl.builder()
				.validator(validator)
				.modelMapper(modelMapper)
				.articleRepository(articleRepository)
				.articleAuthorRepository(articleAuthorRepository)
				.mapperArticleAuthorToArticleAuthorDto(mapper)
				.build();
	}

}