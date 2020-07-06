package com.cuccatti.springbootpractice.exception.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
