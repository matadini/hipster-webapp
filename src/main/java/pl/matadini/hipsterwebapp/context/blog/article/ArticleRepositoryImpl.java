package pl.matadini.hipsterwebapp.context.blog.article;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class ArticleRepositoryImpl implements ArticleRepository {

	EntityManager entityManager;

	@Override
	public Article save(Article entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Article> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Article entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}