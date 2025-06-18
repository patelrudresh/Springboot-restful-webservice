package com.RestApiMvc.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description="user dto class"
		)

@Setter
@Getter 
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
	
	private Long id;
	@Schema(
			description="first name"
			)
	@NotEmpty(message="User first name shouls not be null")
	private  String firstName;
	
	@Schema(
			description="last name"
			)
	@NotEmpty(message="User Last name shouls not be null")
	private String lastName;
	
	@Schema(
			description="email"
			)
	@NotEmpty(message="User email shouls not be null")
	@Email(message=" email should not be valid")
	private String email;
}
