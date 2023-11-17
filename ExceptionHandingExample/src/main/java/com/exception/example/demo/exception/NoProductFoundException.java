package com.exception.example.demo.exception;

public class NoProductFoundException extends RuntimeException {
	
	public NoProductFoundException(String message) {
		super(message);
	}

}
