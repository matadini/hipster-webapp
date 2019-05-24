package pl.matadini.hipsterwebapp.context.blog.article.dto.read;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

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