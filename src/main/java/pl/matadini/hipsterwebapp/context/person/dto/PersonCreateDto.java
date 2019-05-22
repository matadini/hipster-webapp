package pl.matadini.hipsterwebapp.context.person.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonCreateDto {

	@NotEmpty
	String name;

	@NotEmpty
	String email;

	@NotEmpty
	String surname;
}