package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.exception.OrderNotFoundException;
import com.order.repository.OrderRepository;



@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;

	@Override
	public String createOrder(Order order) {
		repo.save(order);
		return "Order created successfully";
	}

	@Override
	public Order getOrderById(Long id) {
		return repo.findById(id).orElseThrow(()->new OrderNotFoundException("Order not found"));
	}

}
