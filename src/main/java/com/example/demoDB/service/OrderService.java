package com.example.demoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoDB.model.Order;
import com.example.demoDB.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired 
	OrderRepository orderRepository;
	
	Order order = new Order();
	
	public List <Order> getAllOrder(){
		
		List<Order> order = orderRepository.findAll();
		
		return order;
	}
	
	public void AddOrder(Order order) {
		
		
		orderRepository.save(order);
		
		System.out.println("Order Placed");
	}
	

}
