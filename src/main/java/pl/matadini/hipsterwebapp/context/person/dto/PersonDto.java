package pl.matadini.hipsterwebapp.context.person.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonDto {

	Long personId;

	String name;

	String surname;

	String email;

}