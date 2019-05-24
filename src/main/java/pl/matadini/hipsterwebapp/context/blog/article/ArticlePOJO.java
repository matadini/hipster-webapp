package pl.matadini.hipsterwebapp.context.blog.article;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
class ArticlePOJO {

	Long articleId;

	String title;

	String content;
}