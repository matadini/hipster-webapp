package pl.matadini.hipsterwebapp.context.blog.author.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorSaveDto {

	@NotEmpty
	String name;

	@NotEmpty
	String surname;

	@NotNull
	LocalDate birthDate;
}