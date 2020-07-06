package com.cuccatti.springbootpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuccatti.springbootpractice.constants.SpringBootPracticeConstants;
import com.cuccatti.springbootpractice.exception.exceptions.UserNotFoundException;
import com.cuccatti.springbootpractice.model.User;
import com.cuccatti.springbootpractice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String userId) throws UserNotFoundException {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
				String.format(SpringBootPracticeConstants.USER_NOT_FOUND_MESSAGE, userId)));
	}

	public User createUser(User User) {
		return userRepository.save(User);
	}

	public User updateUser(User userDetails) throws UserNotFoundException {
		
		User user = userRepository.findById(userDetails.getId()).orElseThrow(() -> new UserNotFoundException(
				String.format(SpringBootPracticeConstants.USER_NOT_FOUND_MESSAGE, userDetails.getId())));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		return userRepository.save(user);
	}

	public void deleteUser(String userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
				String.format(SpringBootPracticeConstants.USER_NOT_FOUND_MESSAGE, userId)));
		userRepository.delete(user);
	}
}
