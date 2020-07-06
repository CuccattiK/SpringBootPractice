package com.cuccatti.springbootpractice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuccatti.springbootpractice.exception.exceptions.UserNotFoundException;
import com.cuccatti.springbootpractice.model.User;
import com.cuccatti.springbootpractice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/api/v1/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation("Get all users")
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@ApiOperation("Get user by ID")
	@GetMapping("/{id}") 
	public User getUserById(@PathVariable String userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}
	
	@ApiOperation("Create user")
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@ApiOperation("Update user")
	@PutMapping("/update")
	public User updateUser(@RequestBody User userDetails) throws UserNotFoundException {
		return userService.updateUser(userDetails);	
	}
	
	@ApiOperation("Delete user")
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable (value = "id") String userId) throws UserNotFoundException {
		userService.deleteUser(userId);
	}
}