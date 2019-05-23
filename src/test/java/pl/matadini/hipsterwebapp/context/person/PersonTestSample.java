package pl.matadini.hipsterwebapp.context.person;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.matadini.hipsterwebapp.context.person.dto.PersonSaveDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PersonTestSample {
	static PersonSaveDto createPersonSaveDtoSampleJanuszNosacz() {
		PersonSaveDto build = PersonSaveDto.builder()
				.name("Janusz")
				.surname("Nosacz")
				.email("xxx@gmail.com")
				.build();
		return build;
	}

	static PersonSaveDto createPersonSaveDtoSampleJanuszNosaczUpdate() {
		PersonSaveDto build = PersonSaveDto.builder()
				.name("Janusz-Update")
				.surname("Nosacz-update")
				.email("xxx@gmail.com-update")
				.build();
		return build;
	}
}