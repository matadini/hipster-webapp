package pl.matadini.hipsterwebapp.context.blog.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import pl.matadini.hipsterwebapp.context.blog.article.dto.ArticleAuthorDto.ArticleAuthorDtoBuilder;

@Value
@Builder
@AllArgsConstructor
public class ArticleAuthorDto {
	Long articleAuthorId;

	String name;

	String surname;
}