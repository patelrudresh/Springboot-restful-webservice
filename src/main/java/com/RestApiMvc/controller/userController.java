package com.RestApiMvc.controller;

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


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
=======

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Tag(name = " CURD Rest-Api for user resource", description = "create user , update user, get user,get all user , delete user")

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class userController {

	private userService userservice;

	// build create user resat api
	@Operation(summary = "create user rest api", description = "create user rest api is used to save in database")
	@ApiResponse(responseCode = "201", description = "http status 201 created")
	@PostMapping
	public ResponseEntity<userDto> createuser(@Valid @RequestBody userDto user) {
		userDto savedUser = userservice.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get user by id Rest Api
	@Operation(summary = "get user by rest api", description = "get user by rest  api is used to get single user from database")
	@ApiResponse(responseCode = "200", description = "http status 200 success")
	@GetMapping("{id}")
	public ResponseEntity<userDto> getUserById(@PathVariable("id") Long userId) {
		userDto user = userservice.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// build get user by id Rest Api
	@Operation(summary = "get user by rest api", description = "get user by rest  api is used to get single user from database")
	@ApiResponse(responseCode = "200", description = "http status 200 success")

	@GetMapping
	public ResponseEntity<List<userDto>> getAllUser() {
		List<userDto> allUser = userservice.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}

	// build get user by id Rest Api
	@Operation(summary = "update user by rest api", description = "uodate user by rest  api is used to update user from database")
	@ApiResponse(responseCode = "200", description = "http status 200 success")
	@PutMapping("{id}")
	public ResponseEntity<userDto> updateUser(@PathVariable("id") Long UserId, @RequestBody @Valid userDto user) {
		user.setId(UserId);
		userDto updatedUser = userservice.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// build get user by id Rest Api
	@Operation(summary = "delete user by rest api", description = "delete user by rest  api is used to delete single user from database")
	@ApiResponse(responseCode = "200", description = "http status 200 success")
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
