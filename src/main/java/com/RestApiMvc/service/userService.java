package com.RestApiMvc.service;

import java.util.List;

import com.RestApiMvc.Dto.userDto;
import com.RestApiMvc.entity.User;

public interface userService {
	userDto createUser(userDto user);
	userDto getUserById(Long UserId);
	List<userDto> getAllUser();
	userDto updateUser(userDto user);
	void deleteUser(Long Userid);
}
