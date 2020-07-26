package com.orderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderService.client.OrderItemsClient;
import com.orderService.model.OrderItem;
import com.orderService.model.Orders;
import com.orderService.repository.OrdersRepository;

@Service
public class OrderService {

	@Autowired
	private OrdersRepository repository;

	@Autowired
	private OrderItemsClient client;

	public Orders getOrder(Integer orderId) {
		List<OrderItem> orderItems = client.getOrderItemsById(orderId);
		Orders order = repository.findOne(orderId);
		if (order != null) {
			order.setOrderItems(orderItems);
		}
		return order;
	}

	public Orders saveOrder(Orders order) {

		if (order.getOrderItems() != null && !order.getOrderItems().isEmpty())
			client.saveOrderItems(order.getOrderItems());
		return repository.save(order);
	}
}
