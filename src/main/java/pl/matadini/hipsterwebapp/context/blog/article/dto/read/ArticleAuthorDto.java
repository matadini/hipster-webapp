package pl.matadini.hipsterwebapp.context.blog.article.dto.read;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class ArticleAuthorDto {
	Long articleAuthorId;

	String name;

	String surname;
}