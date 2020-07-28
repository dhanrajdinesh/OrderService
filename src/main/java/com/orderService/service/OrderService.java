package com.orderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderService.client.OrderItemsClient;
import com.orderService.exception.ResourceNotFoundException;
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
		Orders order = repository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order details not found for OrderId: " + orderId));
		List<OrderItem> orderItems = client.getOrderItemsById(orderId);
		order.setOrderItems(orderItems);
		return order;
	}

	public void saveOrder(Orders order) {
		if (order.getOrderItems() != null && !order.getOrderItems().isEmpty()) {
			order.getOrderItems().forEach(orderItem -> orderItem.setOrderId(order.getOrderId()));
			client.saveOrderItems(order.getOrderItems());
		}
		repository.save(order);
	}
}
