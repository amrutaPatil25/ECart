package com.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.app.dto.CategoryProductsDto;
import com.cart.app.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
	@Query(value = "SELECT new com.cart.app.dto.CategoryProductsDto(c.name,c.des,p.productName,p.price,p.descrip)"
			+"FROM Category c INNER JOIN c.products p where c.name LIKE %:categoryName%")
	public List<CategoryProductsDto> findByCategoryName(@Param("categoryName") String categoryName);
	
	public List<Product> findByProductNameContains(String productName);
	
	@Query(value = "SELECT new com.cart.app.dto.CategoryProductsDto(c.name,c.des,p.productName,p.price,p.descrip)"
			+"FROM Category c INNER JOIN c.products p where c.name LIKE %:categoryName% And p.productName LIKE %:productName%")
	public List<CategoryProductsDto> findByCategoryNameContainsAndProductNameContains(@Param("categoryName") String categoryName,@Param("productName") String productName);

}
