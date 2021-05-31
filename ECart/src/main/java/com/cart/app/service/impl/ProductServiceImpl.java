package com.cart.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.app.dto.CategoryProductsDto;
import com.cart.app.dto.ProductOrderDto;
import com.cart.app.entity.Product;
import com.cart.app.exception.ProductNotFoundException;
import com.cart.app.repository.ProductRepository;
import com.cart.app.service.ProductService;
/**
 * 
 * @author Amruta
 *
 */

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prodRepository;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	/**
	 * This method returns product details by category name
	 * 
	 * @param category name
	 * @return List<CategoryProductsDto>
	 */
	@Override
	public List<CategoryProductsDto> getProductsByCategoryNameContains(@RequestParam String categoryName) {

		List<CategoryProductsDto> dtos=prodRepository.findByCategoryName(categoryName);
		if(dtos.isEmpty())
		{
			logger.error("product not available");
			throw new ProductNotFoundException("Product not found");
		}
		return dtos;
		
	}
	@Override
	public List<CategoryProductsDto> getAllProductByProductName(@RequestParam String productName) {
		// TODO Auto-generated method stub
		List<CategoryProductsDto> dto=new ArrayList<CategoryProductsDto>();
		List<Product> products = prodRepository.findByProductNameContains(productName);
		
		if(products.isEmpty())
		{
			logger.error("Product not available");
			throw new ProductNotFoundException("Product not found");
		}
		for(Product p: products)
		{
			Product prodct = new Product();
			com.cart.app.entity.Category c = new com.cart.app.entity.Category();
			BeanUtils.copyProperties(p, prodct);
			BeanUtils.copyProperties(p.getCatagory(), c);
			
			CategoryProductsDto cpDto = new CategoryProductsDto(c.getName(),c.getDes(), p.getProductName(), p.getPrice(), p.getDescrip());
			dto.add(cpDto);
		}
		
		return dto;
	}
	@Override
	public List<CategoryProductsDto> getProductsByCategoryNameAndProductName(String categoryName, String productName) {
		// TODO Auto-generated method stub
		List<CategoryProductsDto> dto = prodRepository.findByCategoryNameContainsAndProductNameContains(categoryName, productName);
		if(dto.isEmpty())
		{
			logger.error("product not available");
			throw new ProductNotFoundException("Product not found");
		}
		return dto;
	}
	@Override
	public String buyProduct(ProductOrderDto productOrderDto) {
		
		return null;
	}
	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = prodRepository.findById(productId);
		if(product.isPresent())
		{
			return product.get();
		}
		else
		{
		
			throw new ProductNotFoundException("Invalid product Id");
		}
	}
	@Override
	public String updateProduct(Product product) {
		Product p=getProductById(product.getProductId());
		prodRepository.save(p);
		return "product updated";
	}

}
