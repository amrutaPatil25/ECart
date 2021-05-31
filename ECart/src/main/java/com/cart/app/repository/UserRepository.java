package com.cart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
