package com.exception.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = NoProductFoundException.class)
	public ResponseEntity<APIError> handleNoProductFoundException(){
		
		APIError apiError = new APIError(400, "No Product Found", new Date());
		
		return new ResponseEntity<APIError>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ProductFoundException.class)
	public ResponseEntity<APIError> handleProductFoundException(){
		
		APIError apiError = new APIError(200, "Product Found", new Date());
		
		return new ResponseEntity<APIError>(apiError, HttpStatus.FOUND);
	}

}
