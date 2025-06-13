package com.RestApiMvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiMvc.entity.User;
import com.RestApiMvc.service.userService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor

@RequestMapping("api/users")
public class userController {

	private userService userservice;

	// build create user resat api 
	@PostMapping
	public ResponseEntity<User> createuser(@RequestBody User user) {
		User savedUser = userservice.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	// build get user by id Rest Api
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user= userservice.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser=userservice.getAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser( @PathVariable ("id") Long UserId ,
		@RequestBody	User user){
	 	user.setId(UserId);
		User updatedUser=userservice.updateUser(user);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteuser(@PathVariable ("id") Long userid){
		userservice.deleteUser(userid);
		return new ResponseEntity<>("user has been succesfully deleted",HttpStatus.OK);
	}
}
