package pl.matadini.hipsterwebapp.context.person;

import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.person.dto.PersonDto;
import pl.matadini.hipsterwebapp.context.person.dto.PersonSaveDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PersonUtil {

	static Function<? super Person, ? extends PersonDto> personToPersonDto() {
		return x -> PersonDto.builder()
				.email(x.getEmail())
				.name(x.getName())
				.surname(x.getSurname())
				.personId(x.getPersonId())
				.build();
	}

	static Function<? super PersonDto, ? extends PersonSaveDto> personDtoToPersonSaveDto() {
		return source -> PersonSaveDto.builder()
				.name(source.getName())
				.email(source.getEmail())
				.surname(source.getSurname())
				.build();

	}

}