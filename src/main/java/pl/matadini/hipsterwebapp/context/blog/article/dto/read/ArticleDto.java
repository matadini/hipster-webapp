package pl.matadini.hipsterwebapp.context.blog.article.dto.read;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ArticleDto {
	Long articleId;

	String title;

	String content;
	
	String viewUUID;
}