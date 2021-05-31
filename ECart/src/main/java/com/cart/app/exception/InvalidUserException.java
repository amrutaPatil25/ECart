package com.cart.app.exception;

public class InvalidUserException extends RuntimeException {
	
	String message;

	public InvalidUserException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
