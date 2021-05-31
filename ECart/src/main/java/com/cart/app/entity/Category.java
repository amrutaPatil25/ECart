package com.cart.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author Amruta
 *
 */
@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
/**
 * describes the category name
 */
	private String name ;
	/**
	 * describes the category description
	 */
	private String des;
	
	@OneToMany(mappedBy = "catagory")
List<Product> products;

	public Category()
	{
		
	}
	
	/**
	 * This method return categoryId
	 * @return categoryId
	 */
	
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * This method set the categoryId
	 * @param categoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * this method returns list of products
	 * @return products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * this method returns category name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * this method set the category name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method returns description of category
	 * @return description
	 */
	public String getDes() {
		return des;
	}
	
	/**
	 * this method set description of category
	 * @param des
	 */
	public void setDes(String des) {
		this.des = des;
	}
	
}
