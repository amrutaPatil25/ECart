package com.cart.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.app.dto.CategoryProductsDto;
import com.cart.app.entity.Product;
import com.cart.app.service.ProductService;
/**
 * 
 * @author Amruta
 *
 */
@RestController
//@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	/**
	 * this method return product details by taking input as a category name
	 * @param categoryName
	 * @return 
	 */
	@GetMapping("/category/{categoryName}/products")
	public ResponseEntity<List<CategoryProductsDto>> getProductsByCategoryName(@RequestParam String categoryName)
	{
		List<CategoryProductsDto> dto = productService.getProductsByCategoryNameContains(categoryName);
		return new ResponseEntity<List<CategoryProductsDto>>(dto,HttpStatus.OK);
	}
	
	/**
	 * this method return product details by taking input as a product name
	 * @param name
	 * @return
	 */
	
	@GetMapping("products/getbyname")
	public ResponseEntity<List<CategoryProductsDto>> getProductsByProductName(@RequestParam String name)
	{
		List<CategoryProductsDto> dto = productService.getAllProductByProductName(name);
		return new ResponseEntity<List<CategoryProductsDto>>(dto,HttpStatus.OK);
	}
	

	/**
	 * this method return product details by taking input as a category name and product name
	 * @param CatName
	 * @param prodName
	 * @return
	 */
	@GetMapping("/products")
	public ResponseEntity<List<CategoryProductsDto>> getProductsByCategoryNameAndProductName(@RequestParam(required = false) String CatName,@RequestParam(required = false) String prodName)
	{
		List<CategoryProductsDto> dto = productService.getProductsByCategoryNameAndProductName(CatName, prodName);
		
		return new ResponseEntity<List<CategoryProductsDto>>(dto,HttpStatus.OK);
	}
}
