package com.example.demoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoDB.model.Customer;
import com.example.demoDB.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	
}
