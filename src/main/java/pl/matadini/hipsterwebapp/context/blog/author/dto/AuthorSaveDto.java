package pl.matadini.hipsterwebapp.context.blog.author.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorSaveDto {

	@NotEmpty
	String name;

	@NotEmpty
	String surname;

	@NotEmpty
	LocalDate birthDate;
}