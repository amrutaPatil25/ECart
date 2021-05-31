package com.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,	Integer>{

	List<OrderDetails> findByOrder(Order order);
}
