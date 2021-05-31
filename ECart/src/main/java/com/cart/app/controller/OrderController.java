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

import com.cart.app.dto.OrderResponseDto;
import com.cart.app.service.OrderService;
/**
 * 
 * @author Amruta
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;
	/**
	 * this method return number of order details placed by user by using userId
	 * @param userId
	 * @return Orderdetails
	 */
	
	@GetMapping("/user/{userId}/order")
	public ResponseEntity<List<OrderResponseDto>> orderHistory(@RequestParam Integer userId)
	{
		logger.info("order history by user id");
		List<OrderResponseDto> orders = orderService.getOrderDetailsByUserId(userId);
		
		return new ResponseEntity<List<OrderResponseDto>>(orders,HttpStatus.OK);
	}

}
