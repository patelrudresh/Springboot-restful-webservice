package com.RestApiMvc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring boot Rest APi Dacumentation", description = "Spring boot Rest APi Dacumentation", version = "v1.0", contact = @Contact(name = "Ramesh", email = "ramesh@gamil.com", url = "https://www.gogle.com")

), externalDocs = @ExternalDocumentation(description = "spring boot user management dacumentation"))
public class RestApiMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMvcApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
