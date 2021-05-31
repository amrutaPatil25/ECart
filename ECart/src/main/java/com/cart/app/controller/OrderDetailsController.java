package com.cart.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.app.dto.ProductOrderDto;
import com.cart.app.entity.OrderDetails;
import com.cart.app.service.OrderDetailsService;
/**
 * 
 * @author Amruta
 *
 */
@RestController
@RequestMapping("/order")
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderService;
	
	Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);
	
	/**
	 * This method place the order by taking input of product details and user details like userId,accountNumber,productId and quantity 
	 * @param productOrder
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> buyProduct(@Valid @RequestBody  ProductOrderDto productOrder)
	{
		logger.info("buy product");
		//OrderDetails orderDetails = new OrderDetails();
		//BeanUtils.copyProperties(productOrder, orderDetails);
		orderService.addOrderDetails(productOrder);
		
		return new ResponseEntity<String>("order placed",HttpStatus.CREATED);
	}
}
