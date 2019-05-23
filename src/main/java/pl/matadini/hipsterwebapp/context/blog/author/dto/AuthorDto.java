package pl.matadini.hipsterwebapp.context.blog.author.dto;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public class AuthorDto {
	Long authorId;

	String name;

	String surname;

	LocalDateTime createDate;
}