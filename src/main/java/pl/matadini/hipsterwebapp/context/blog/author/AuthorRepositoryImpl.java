package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class AuthorRepositoryImpl implements AuthorRepository {
	
	EntityManager entityManager;

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Author entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Author> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author save(Author entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}