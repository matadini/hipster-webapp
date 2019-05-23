package pl.matadini.hipsterwebapp.context.blog.author;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "authors")
class Author {

	@Id
	@Column(name = "author_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long authorId;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "surname", nullable = false)
	String surname;

	@Column(name = "email")
	String email;

	@Column(name = "birth_date", nullable = false)
	LocalDate birthDate;

	public Author(String name, String surname, LocalDate birthDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

}
