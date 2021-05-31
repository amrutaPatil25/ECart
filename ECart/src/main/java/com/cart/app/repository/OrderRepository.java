package com.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.app.entity.Order;
import com.cart.app.entity.OrderDetails;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	@Query(value="from Order o where o.user.userId=:userId")
	public List<Order> findByUserId(@Param("userId") Integer userId); 
}
