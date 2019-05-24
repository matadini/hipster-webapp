package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lombok.AllArgsConstructor;
import pl.matadini.hipsterwebapp.shared.jpa.JpaRepositoryUtil;

@AllArgsConstructor
class ArticleRepositoryImpl implements ArticleRepository {

	EntityManager entityManager;

	@Override
	public Long count() {
		String qlString = "select count(a.articleId) from Article a";
		TypedQuery<Long> createQuery = entityManager.createQuery(qlString, Long.class);
		return createQuery.getSingleResult();
	}

	@Override
	public void delete(Article entity) {
		JpaRepositoryUtil.delete(entity, entityManager);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Article> findAll() {
		String qlString = "select a from Article a order by a.articleId";
		TypedQuery<Article> query = entityManager.createQuery(qlString, Article.class);
		return query.getResultList();
	}

	@Override
	public Optional<Article> findById(Long id) {
		return Optional.ofNullable(entityManager.find(Article.class, id));
	}

	@Override
	public Article save(Article entity) {
		return JpaRepositoryUtil.merge(entity, entityManager);
	}

}