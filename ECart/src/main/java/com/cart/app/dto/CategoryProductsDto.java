package com.cart.app.dto;

public class CategoryProductsDto {

	
	String categoryName;
	String categoryDesc;
	String productName;
	double price;
	String productDesc;
	
	
	
	public CategoryProductsDto(String categoryName, String categoryDesc, String productName, double price,
			String productDesc) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.productName = productName;
		this.price = price;
		this.productDesc = productDesc;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	
}
