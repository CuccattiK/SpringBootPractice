package com.cuccatti.springbootpractice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cuccatti.springbootpractice.constants.SpringBootPracticeConstants;
import com.cuccatti.springbootpractice.exception.exceptions.UserNotFoundException;
import com.cuccatti.springbootpractice.exception.model.ErrorHandlerResponse;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorHandlerResponse userNotFoundExceptionHandler(UserNotFoundException ex) {
		return ErrorHandlerResponse
				.builder()
				.message(String.format(SpringBootPracticeConstants.USER_NOT_FOUND_MESSAGE,ex.getMessage()))
				.isError(true)
				.build();
	}
}
