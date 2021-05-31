package com.cart.app.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.app.controller.OrderDetailsController;
import com.cart.app.dto.ProductDto;
import com.cart.app.dto.ProductOrderDto;
import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;
import com.cart.app.entity.Product;
import com.cart.app.entity.User;
import com.cart.app.exception.ProductNotFoundException;
import com.cart.app.exception.TransactionFailedException;
import com.cart.app.feginclient.ECartBankClient;
import com.cart.app.repository.OrderDetailsRepository;
import com.cart.app.service.OrderDetailsService;
import com.cart.app.service.OrderService;
import com.cart.app.service.ProductService;
import com.cart.app.service.UserService;
/**
 * 
 * @author Amruta
 *
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);
	
	
	@Autowired
	ECartBankClient eCartBankClient;
	
	@Autowired
	OrderDetailsRepository orderRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;

	int reqQuan = 0;
	int availQuan = 0;
	double totalPrice=0.0;
	int totalQuan = 0;
	@Override
	public void addOrderDetails(ProductOrderDto orderDto) {
		// TODO Auto-generated method stub
		
		//orderRepository.save(order);
		//double totalPrice=0;
		
	//	int totalQuantity=0;
		
		
		List<ProductDto> products = orderDto.getProducts();
		List<Product> product = new ArrayList<Product>();
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		User user = userService.getUserById(orderDto.getUserId());
		
		Order orderAddDb = new Order();
		products.forEach(p->{
		
			Product prod = productService.getProductById(p.getProductId());
			availQuan = prod.getQuantity();
			reqQuan = p.getQuantity();
		 
			if(availQuan<reqQuan)
				{
					throw new ProductNotFoundException("product not availble");
				}
			totalQuan = totalQuan + reqQuan;
			totalPrice = totalPrice + (prod.getPrice()*reqQuan);
		
		});
		
		String msg = eCartBankClient.fundTransfer(orderDto.getAccountNumber(), 98745, totalPrice);
		
		if(!msg.equals("successful"))
		{
			logger.error("transaction failed");
			throw new TransactionFailedException("Transaction failed");
		}
		
		logger.info("transaction successful!");
		
		products.forEach( p->
		{
			Product prod = productService.getProductById(p.getProductId());
			
			availQuan = prod.getQuantity();
			reqQuan = p.getQuantity();
		 
			OrderDetails orderDetail = new OrderDetails();			
			
			prod.setQuantity(availQuan-reqQuan);
			product.add(prod);
			productService.updateProduct(prod);
			
			orderDetail.setProducts(prod);
			orderDetail.setQuantity(reqQuan);
			orderDetail.setPrice(prod.getPrice()*p.getQuantity());
			//orderRepository.save(orderDetail);
			orderDetail.setOrder(orderAddDb);
			orderDetails.add(orderDetail);
			
		});
		logger.info("order details added");
		
		
		orderAddDb.setDateTime(LocalDate.now());
		//orderAddDb.setOrderId(1);
		orderAddDb.setOrders(orderDetails);
		orderAddDb.setTotalPrice(totalPrice);
		orderAddDb.setUser(user);
		
		orderService.addOrder(orderAddDb);
		
		logger.info("order added");
		
		orderDetails.forEach(o -> orderRepository.save(o));
	
		logger.info("order placed");
	}

	@Override
	public List<OrderDetails> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrder(order);
	}
	
	

	

}
