package com.glearning.collegefest.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleInvalidSudentId(IllegalArgumentException e) {
		return "Invalid Student id is passed";
	}

}
