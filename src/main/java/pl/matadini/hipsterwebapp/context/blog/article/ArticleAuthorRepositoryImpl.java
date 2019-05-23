package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class ArticleAuthorRepositoryImpl implements ArticleAuthorRepository {

	EntityManager entityManager;

	@Override
	public ArticleAuthor save(ArticleAuthor entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<ArticleAuthor> findById(Long id) {
		return Optional.ofNullable(entityManager.find(ArticleAuthor.class, id));
	}

	@Override
	public void delete(ArticleAuthor entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ArticleAuthor> findAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long count() {
		throw new UnsupportedOperationException();
	}

}