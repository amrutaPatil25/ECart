package com.cart.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.app.dto.OrderResponseDto;
import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;
import com.cart.app.exception.InvalidUserException;
import com.cart.app.repository.OrderRepository;
import com.cart.app.service.OrderDetailsService;
import com.cart.app.service.OrderService;
/**
 * 
 * @author Amruta
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	OrderRepository orderRepostory;
	@Autowired
	OrderDetailsService orderDetailsService;
	
	/**
	 * This method save the order 
	 * 
	 *@param Order 
	 */
	@Override
	public String addOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepostory.save(order);
		logger.info("order added");
		return "order added";
	}
	@Override
	public List<OrderResponseDto> getOrderDetailsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<OrderResponseDto> orderResponse = new ArrayList<OrderResponseDto>();
		List<Order> order = orderRepostory.findByUserId(userId);
		if(order.isEmpty())
		{
			logger.error("wrong user id");
			throw new InvalidUserException("user id not found");
		}
		for(Order o : order)
		{
			List<OrderDetails> orderDetails = orderDetailsService.findByOrder(o);			
			for(OrderDetails orders : orderDetails)
			{
				OrderResponseDto dto = new OrderResponseDto();
				dto.setDateTime(o.getDateTime());
				dto.setPrice(orders.getPrice());
				dto.setProductName(orders.getProducts().getProductName());
				dto.setQuantity(orders.getQuantity());
				
				orderResponse.add(dto);
			
			}
		
		}	
		return orderResponse;
	

}
}
