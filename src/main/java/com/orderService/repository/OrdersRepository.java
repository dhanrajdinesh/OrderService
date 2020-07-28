package com.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderService.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
