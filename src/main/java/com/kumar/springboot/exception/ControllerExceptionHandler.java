package com.kumar.springboot.exception;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception, WebRequest request){
		 ErrorMessage message = new ErrorMessage(
			        HttpStatus.NOT_FOUND.value(),
			        new Date(),
			        exception.getMessage(),
			        request.getDescription(false));
		 return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler(DataAccessException.class)
	 public ResponseEntity<ErrorMessage> dataAccessException(WebRequest request){
		 ErrorMessage message = new ErrorMessage(
			        HttpStatus.NOT_FOUND.value(),
			        new Date(),
			        "User does not found",
			        request.getDescription(false));
		 return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	 }
	 

}
