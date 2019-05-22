package pl.matadini.hipsterwebapp.context.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;

	private String name;

	private String surname;
	
	private String email;

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

}
