package com.RestApiMvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RestApiMvc.entity.User;
import com.RestApiMvc.repository.UserRepository;
import com.RestApiMvc.service.userService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceImpl implements userService {

	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long UserId) {

		Optional<User> optinalUser = userRepository.findById(UserId);
		return optinalUser.get();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatesUser = userRepository.save(existingUser);
		return updatesUser;
	}

	@Override
	public void deleteUser(Long Userid) {
		userRepository.deleteById(Userid);
		
	}
}
