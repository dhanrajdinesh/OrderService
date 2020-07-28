package com.orderService.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Orders {

	@Id
	@NotNull(message = "Order Id should not be null")
	private Integer orderId;
	@NotEmpty(message = "Customer name is required")
	private String customerName;
	@NotNull(message = "Order Date is required")
	private Date orderDate;
	@NotEmpty(message = "Order Id should not be null")
	private String shippingAddress;

	@JsonInclude()
	@Transient
	private List<OrderItem> orderItem;

	private Double total;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItem;
	}

	public void setOrderItems(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

}
