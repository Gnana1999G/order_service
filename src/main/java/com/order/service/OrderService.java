package com.order.service;

import com.order.entity.Order;

public interface OrderService {
	
	public String createOrder(Order order);
	
	Order getOrderById(Long id);

}
