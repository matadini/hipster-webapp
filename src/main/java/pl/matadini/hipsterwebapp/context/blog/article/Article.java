package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
class Article {

	@Id
	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long articleId;

	@Column(nullable = false)
	String title;

	@Column(nullable = false)
	String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", nullable = false)
	ArticleAuthor articleAuthor;

}
