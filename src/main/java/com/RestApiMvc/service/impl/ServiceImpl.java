package com.RestApiMvc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RestApiMvc.Dto.userDto;
import com.RestApiMvc.entity.User;
import com.RestApiMvc.mapper.userMapper;
import com.RestApiMvc.repository.UserRepository;
import com.RestApiMvc.service.userService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ServiceImpl implements userService {

	private UserRepository userRepository;

	@Override
	public userDto createUser(userDto userDto) {
		// convert userdto into jpa entity
		User user =userMapper.maptoUser(userDto);
		User savedUser = userRepository.save(user);
		// convert user jpa to userdto entity
		userDto saveduserDto = userMapper.maptoserDto(savedUser);
		return saveduserDto;
	}

	@Override
	public userDto getUserById(Long UserId) {

		Optional<User> optinalUser = userRepository.findById(UserId);
		User user= optinalUser.get();
		return userMapper.maptoserDto(user);
	}

	@Override
	public List<userDto> getAllUser() {
		 List<User> user =userRepository.findAll();
		 return user.stream().map(userMapper::maptoserDto).collect(Collectors.toList());

	}

	@Override
	public userDto updateUser(userDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatesUser = userRepository.save(existingUser);
		
		return userMapper.maptoserDto(updatesUser);
	}

	@Override
	public void deleteUser(Long Userid) {
		userRepository.deleteById(Userid);

	}
}
