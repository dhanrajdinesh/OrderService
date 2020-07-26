package com.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.model.Orders;
import com.orderService.service.OrderService;

@RestController
public class OrderServiceController {

	@Autowired
	private OrderService service;

	@GetMapping("/order/{id}")
	public Orders getOrder(@PathVariable Integer id) {
		return service.getOrder(id);
	}

	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody Orders order) {
		if (order == null) {
			return;
		}
		service.saveOrder(order);
	}
}
