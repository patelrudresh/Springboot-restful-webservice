package com.RestApiMvc.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.RestApiMvc.Dto.userDto;
import com.RestApiMvc.Exception.ErrorDetails;
import com.RestApiMvc.Exception.ResourceNotFoundException;
import com.RestApiMvc.entity.User;
import com.RestApiMvc.service.userService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor

@RequestMapping("api/users")
public class userController {

	private userService userservice;

	// build create user resat api
	@PostMapping
	public ResponseEntity<userDto> createuser(@Valid @RequestBody userDto user) {
		userDto savedUser = userservice.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get user by id Rest Api
	@GetMapping("{id}")
	public ResponseEntity<userDto> getUserById(@PathVariable("id") Long userId) {
		userDto user = userservice.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<userDto>> getAllUser() {
		List<userDto> allUser = userservice.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<userDto> updateUser(@PathVariable("id") Long UserId, @RequestBody @Valid userDto user) {
		user.setId(UserId);
		userDto updatedUser = userservice.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteuser(@PathVariable("id") Long userid) {
		userservice.deleteUser(userid);
		return new ResponseEntity<>("user has been succesfully deleted", HttpStatus.OK);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> resourcenotfoundException(ResourceNotFoundException exception,
//			WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
//				webRequest.getDescription(false),"user_Not_Found");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
