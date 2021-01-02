package com.spring.employee.employeeManagement.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SearchRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<SearchErrorResponse> handleException(SearchNotFoundException e) {
		
		//create error response
		SearchErrorResponse errorResponseBody = new SearchErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				e.getMessage(),
				System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(errorResponseBody, HttpStatus.NOT_FOUND);
	}
	
	//global handler to catch all exceptions
	@ExceptionHandler
	public ResponseEntity<SearchErrorResponse> handleException(Exception e) {
		
		//create error response
		SearchErrorResponse errorResponseBody = new SearchErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				e.getMessage(),
				System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(errorResponseBody, HttpStatus.BAD_REQUEST);
	}
}
