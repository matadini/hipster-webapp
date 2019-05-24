package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;

import lombok.Builder;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto;
import pl.matadini.hipsterwebapp.context.blog.article.dto.write.ArticleSaveDto;

@Builder
class ArticleServiceImpl implements ArticleService {

	Validator validator;
	ModelMapper modelMapper;
	ArticleRepository articleRepository;
	ArticleAuthorRepository articleAuthorRepository;
	Function<? super ArticleAuthor, ? extends ArticleAuthorDto> mapperArticleAuthorToArticleAuthorDto;

	@Override
	public Long createArticle(Long articleAuthorId, ArticleSaveDto data) throws ArticleServiceException {

		Set<ConstraintViolation<ArticleSaveDto>> validate = validator.validate(data);
		if (!validate.isEmpty()) {
			throw new ArticleServiceException("Invalid input data: \n" + validate);
		}

		Optional<ArticleAuthor> findById = articleAuthorRepository.findById(articleAuthorId);
		if (!findById.isPresent()) {
			throw new ArticleServiceException("Invalid input data: articleAuthorId \n");
		}
		ArticleAuthor articleAuthor = findById.get();

		Article map = modelMapper.map(data, Article.class);
		map.setArticleAuthor(articleAuthor);
		map = articleRepository.save(map);
		return map.getArticleId();
	}

	@Override
	public List<ArticleAuthorDto> getArticleAuthors() throws ArticleServiceException {

		return articleAuthorRepository.findAll()
				.stream()
				.map(mapperArticleAuthorToArticleAuthorDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ArticleAuthorWithArticlesDto> getAuthorsWithArticles() throws ArticleServiceException {

		Function<? super ArticleAuthor, ? extends ArticleAuthorWithArticlesDto> mapper = ArticleUtil.authorToAuthorWithArticles();

		List<ArticleAuthor> findAll = articleAuthorRepository.findAll();
		return findAll.stream()
				.map(mapper)
				.collect(Collectors.toList());
	}

}