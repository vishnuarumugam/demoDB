package com.example.demoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demoDB.model.Customer;
import com.example.demoDB.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers=customerService.getAllCustomers();
		return customers;
	}
}
