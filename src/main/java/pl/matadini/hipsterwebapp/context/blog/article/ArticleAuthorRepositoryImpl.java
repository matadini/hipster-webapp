package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class ArticleAuthorRepositoryImpl implements ArticleAuthorRepository {

	EntityManager entityManager;

	@Override
	public Long count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(ArticleAuthor entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ArticleAuthor> findAll() {
		String qlString = "select a from ArticleAuthor a order by a.articleAuthorId";
		TypedQuery<ArticleAuthor> createQuery = entityManager.createQuery(qlString, ArticleAuthor.class);
		return createQuery.getResultList();
	}

	@Override
	public Optional<ArticleAuthor> findById(Long id) {
		return Optional.ofNullable(entityManager.find(ArticleAuthor.class, id));
	}

	@Override
	public ArticleAuthor save(ArticleAuthor entity) {
		throw new UnsupportedOperationException();
	}

}