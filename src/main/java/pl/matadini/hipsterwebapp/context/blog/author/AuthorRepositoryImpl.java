package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lombok.AllArgsConstructor;
import pl.matadini.hipsterwebapp.shared.jpa.JpaRepositoryUtil;

@AllArgsConstructor
class AuthorRepositoryImpl implements AuthorRepository {

	EntityManager entityManager;

	@Override
	public Long count() {
		String qlString = "select count(a.authorId) from Author a";
		TypedQuery<Long> query = entityManager.createQuery(qlString, Long.class);
		return query.getSingleResult();
	}

	@Override
	public void delete(Author entity) {
		JpaRepositoryUtil.delete(entity, entityManager);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Author> findAll() {
		String qlString = "select a from Author a order by a.authorId";
		TypedQuery<Author> query = entityManager.createQuery(qlString, Author.class);
		return query.getResultList();
	}

	@Override
	public Optional<Author> findById(Long id) {
		return Optional.ofNullable(entityManager.find(Author.class, id));
	}

	@Override
	public Author save(Author entity) {
		return JpaRepositoryUtil.merge(entity, entityManager);
	}

}