package pl.matadini.hipsterwebapp.context.person.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

/**
 * DTO used in cause of inserts and updates
 * 
 * @author matadini
 *
 */
@Value
@Builder
public class PersonSaveDto {

	@NotEmpty
	String name;

	@NotEmpty
	String email;

	@NotEmpty
	String surname;
}