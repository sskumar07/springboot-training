package com.kumar.springboot.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
