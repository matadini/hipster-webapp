package pl.matadini.hipsterwebapp.context.blog.article.dto.read;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import pl.matadini.hipsterwebapp.context.blog.article.dto.read.ArticleAuthorWithArticlesDto.ArticleAuthorWithArticlesDtoBuilder;

@Value
@Builder
@AllArgsConstructor
public class ArticleAuthorWithArticlesDto {
	Long articleAuthorId;

	String name;

	String surname;
	
	String viewUUID;
	
	List<ArticleDto> articles;
}