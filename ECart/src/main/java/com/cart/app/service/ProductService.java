package com.cart.app.service;

import java.util.List;

import com.cart.app.dto.CategoryProductsDto;
import com.cart.app.dto.ProductOrderDto;
import com.cart.app.entity.Product;

public interface ProductService
{
	public List<CategoryProductsDto> getProductsByCategoryNameContains(String catName);
	
	public List<CategoryProductsDto> getAllProductByProductName(String productName);
	
	public List<CategoryProductsDto> getProductsByCategoryNameAndProductName(String catgoryName,String productName);

	
	public String buyProduct(ProductOrderDto productOrderDto);
	
	public Product getProductById(Integer productId);
	
	public String updateProduct(Product product);
}
