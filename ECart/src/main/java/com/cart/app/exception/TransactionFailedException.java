package com.cart.app.exception;

public class TransactionFailedException extends RuntimeException{
	
	String message;

	public TransactionFailedException(String message) {
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
