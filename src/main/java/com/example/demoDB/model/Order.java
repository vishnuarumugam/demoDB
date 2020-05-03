package com.example.demoDB.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Order {

	@Id
	private Long orderId;
	private Integer customerId;
	private Integer merchantId;
	private Double orderTotalPrice;
	private String deliveryAddress;
	private List<OrderItem> orderItem;

	
	public Order() {
		super();
	}


	public Order(Long orderId, Integer customerId, Integer merchantId, Double orderTotalPrice,
			String deliveryAddress, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.merchantId = merchantId;
		this.orderTotalPrice = orderTotalPrice;
		this.deliveryAddress = deliveryAddress;
		this.orderItem = orderItem;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Integer getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}


	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}


	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	public List<OrderItem> getOrderItem() {
		return orderItem;
	}


	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	
	
	
}
