package com.RestApiMvc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.RestApiMvc.Dto.userDto;
import com.RestApiMvc.Exception.EmailAlreadyExitsException;
import com.RestApiMvc.Exception.ResourceNotFoundException;
import com.RestApiMvc.entity.User;
import com.RestApiMvc.mapper.userMapper;
import com.RestApiMvc.repository.UserRepository;
import com.RestApiMvc.service.userService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceImpl implements userService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Override
	public userDto createUser(userDto userDto) {
		// convert userdto into jpa entity
		// User user =userMapper.maptoUser(userDto);
		
		Optional<User> OptionalUser=userRepository.findByEmail(userDto.getEmail());
		
		if(OptionalUser.isPresent()) {
			throw new EmailAlreadyExitsException("Email already exists  for User");	
		}
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);

		// convert user jpa to userdto entity
		// userDto saveduserDto = userMapper.maptoserDto(savedUser);
		userDto saveduserDto = modelMapper.map(savedUser, userDto.class);

		return saveduserDto;
	}

	@Override
	public userDto getUserById(Long userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		// User user= optinalUser.get();
		return userMapper.maptoserDto(user);
//		return modelMapper.map(user, userDto.class);
	}

	@Override
	public List<userDto> getAllUser() {
		List<User> users = userRepository.findAll();
		// return
		// users.stream().map(userMapper::maptoserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, userDto.class)).collect(Collectors.toList());

	}

	@Override
	public userDto updateUser(userDto user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatesUser = userRepository.save(existingUser);

		// return userMapper.maptoserDto(updatesUser);
		return modelMapper.map(updatesUser, userDto.class);
	}

	@Override
	public void deleteUser(Long userid) {
		User existingUser = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));
		userRepository.deleteById(userid);

	}
}
