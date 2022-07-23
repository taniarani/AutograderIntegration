package com.data.autograder.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorResponseHandler {

	@ExceptionHandler(value = StackOverflowError.class)
	@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
	public ResponseEntity<Object> getReponse(){
		
		return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE); 
	}
}
