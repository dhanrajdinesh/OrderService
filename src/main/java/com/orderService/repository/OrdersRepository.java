package com.orderService.repository;

import org.springframework.data.repository.CrudRepository;

import com.orderService.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}
