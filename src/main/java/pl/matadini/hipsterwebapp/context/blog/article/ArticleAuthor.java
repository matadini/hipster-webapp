package pl.matadini.hipsterwebapp.context.blog.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "authors")
class ArticleAuthor {

	@Id
	@Column(name = "author_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long authorId;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "surname", nullable = false)
	String surname;
}