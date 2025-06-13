package com.RestApiMvc.service;

import java.util.List;

import com.RestApiMvc.entity.User;

public interface userService {
	User createUser(User user);
	User getUserById(Long UserId);
	List<User> getAllUser();
	User updateUser(User user);
	void deleteUser(Long Userid);
}
