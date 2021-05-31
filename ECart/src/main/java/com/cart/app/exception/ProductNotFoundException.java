package com.cart.app.exception;

public class ProductNotFoundException extends RuntimeException
{
	String message;

	public ProductNotFoundException(String message) {
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
