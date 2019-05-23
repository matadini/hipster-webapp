package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Read-only entity
 * 
 * @author matadini
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
class ArticleAuthor {

	@Id
	@Column(name = "author_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long articleAuthorId;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "surname", nullable = false)
	String surname;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articleAuthor")
	Set<Article> articles = Sets.newHashSet();
}