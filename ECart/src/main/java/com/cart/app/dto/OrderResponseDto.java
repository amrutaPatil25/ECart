package com.cart.app.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderResponseDto {
	
	private Integer quantity;
	
	private double price;
	
	private String productName;

	private LocalDate dateTime;
	
	
	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponseDto(Integer quantity, double price, String productName,LocalDate dateTime) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.productName = productName;
		this.dateTime  = dateTime ;
	}

	
	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	

}
