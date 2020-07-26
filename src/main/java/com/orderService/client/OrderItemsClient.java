package com.orderService.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderService.model.OrderItem;

@FeignClient(url = "http://localhost:8080", name = "ORDER-ITEMS-CLIENT")
public interface OrderItemsClient {

	@RequestMapping(value = "/orderItems/orderId/{orderId}", method = RequestMethod.GET, consumes = "application/json")
	public List<OrderItem> getOrderItemsById(@PathVariable("orderId") Integer orderId);

	@RequestMapping(value = "/orderItems", produces = {
			"application/json; charset=UTF-8" }, method = RequestMethod.POST)
	public List<OrderItem> saveOrderItems(@RequestBody List<OrderItem> orderItems);

}
