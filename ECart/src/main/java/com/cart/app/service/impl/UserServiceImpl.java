package com.cart.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.app.entity.User;
import com.cart.app.exception.InvalidUserException;
import com.cart.app.repository.UserRepository;
import com.cart.app.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository UserRepository;
	
	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		Optional<User> user = UserRepository.findById(userId);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new InvalidUserException("invalid user ID");
		}

	}

}
