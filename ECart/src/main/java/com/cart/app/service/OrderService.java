package com.cart.app.service;

import java.util.List;

import com.cart.app.dto.OrderResponseDto;
import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;

public interface OrderService {

	public String addOrder(Order order);
	
	public List<OrderResponseDto> getOrderDetailsByUserId(Integer userId);
}
