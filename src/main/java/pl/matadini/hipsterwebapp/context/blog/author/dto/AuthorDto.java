package pl.matadini.hipsterwebapp.context.blog.author.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorDto {
	Long authorId;

	String name;

	String surname;

	String email;
	
	LocalDate birthDate;
}