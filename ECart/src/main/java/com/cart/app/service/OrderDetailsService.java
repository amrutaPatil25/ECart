package com.cart.app.service;

import java.util.List;

import com.cart.app.dto.ProductOrderDto;
import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;

import io.swagger.v3.oas.models.media.IntegerSchema;
/**
 * This interface declares operations with orderdetails
 * @author Amruta
 *
 */
public interface OrderDetailsService {
	
	public void addOrderDetails(ProductOrderDto order);
	
	public List<OrderDetails> findByOrder(Order order);

}
