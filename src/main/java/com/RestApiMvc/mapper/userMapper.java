package com.RestApiMvc.mapper;

import com.RestApiMvc.Dto.userDto;
import com.RestApiMvc.entity.User;

public class userMapper {

	public static userDto maptoserDto(User user) {
		userDto userDto = new userDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		return userDto;
	}
	
	public static User maptoUser(userDto userdto) {
		User user= new User(
				userdto.getId(),
				userdto.getFirstName(),
				userdto.getLastName(),
				userdto.getEmail()
				);
		return user;
	}

}
