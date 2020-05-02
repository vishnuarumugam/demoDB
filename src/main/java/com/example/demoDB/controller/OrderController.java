package com.example.demoDB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demoDB.model.Order;
import com.example.demoDB.model.OrderItem;
import com.example.demoDB.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	
	
	
	public void placeOrder() {
		
		Order order = new Order();
		
		OrderItem orderItem = new OrderItem(1, 20.0, 40.0, 2);
		OrderItem orderItem1 = new OrderItem(2, 20.0, 40.0, 2);
		
		List <OrderItem> items = new ArrayList<>();
		
		
		  items.add(orderItem); 
		  items.add(orderItem1);
		  
		  order.setOrderId(1); 
		  order.setMerchantId(1); 
		  order.setCustomerId(2);
		  order.setOrderTotalPrice(200.0); 
		  order.setOrderItem(items);
		 
		  
		  
		System.out.println("Added");
		orderService.AddOrder(order);
		
	}

}
