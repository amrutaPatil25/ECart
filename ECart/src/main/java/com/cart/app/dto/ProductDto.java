package com.cart.app.dto;

import javax.validation.constraints.Size;

public class ProductDto {
	
	@Size(min=1,message="product id required")
	private Integer productId;
	
	@Size(min=1,message="quantity required")
	private Integer quantity;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}
