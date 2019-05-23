package pl.matadini.hipsterwebapp.context.blog.author;

import java.util.List;

import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorDto;
import pl.matadini.hipsterwebapp.context.blog.author.dto.AuthorSaveDto;

interface AuthorService {

	Long addAuthor(AuthorSaveDto data) throws AuthorServiceException;

	List<AuthorDto> getAll() throws AuthorServiceException;
}
