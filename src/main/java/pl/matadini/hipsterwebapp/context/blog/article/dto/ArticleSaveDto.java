package pl.matadini.hipsterwebapp.context.blog.article.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ArticleSaveDto {
	
	@NotEmpty
	String title;

	@NotEmpty
	String content;
}
