package com.cart.app.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	
	private String message;
    private LocalDateTime localDateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
    
    
    

}
