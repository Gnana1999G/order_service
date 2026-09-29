package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping
	public String saveOrder(@RequestBody Order order) {
//		Order order=new Order("CUST155", "MOB655", 10, 155000.0, "Available", "Gnanendra", "Gnana", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
		service.createOrder(order);
		return "Success";
	}
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return service.getOrderById(id);
	}

}
