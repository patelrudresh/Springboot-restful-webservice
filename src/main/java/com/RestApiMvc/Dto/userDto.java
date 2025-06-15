package com.RestApiMvc.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
	
	private Long id;
	
	@NotEmpty(message="User first name shouls not be null")
	private  String firstName;
	
	@NotEmpty(message="User Last name shouls not be null")
	private String lastName;
	
	@NotEmpty(message="User email shouls not be null")
	@Email(message=" email should not be valid")
	private String email;
}
