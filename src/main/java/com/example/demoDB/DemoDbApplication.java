package com.example.demoDB;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoDB.repository.CustomerRepository;
import com.example.demoDB.controller.CustomerController;
import com.example.demoDB.model.Customer;

@SpringBootApplication
public class DemoDbApplication implements CommandLineRunner{

	@Autowired
	CustomerController customerController;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//customerRepository.deleteAll();
		
		//customerRepository.save(new Customer("1","Alice", "Smith"));
		//customerRepository.save(new Customer("2","Bob", "Smith"));
		//customerRepository.save(new Customer("3","Vishnu", "Kumar"));
		
		List<Customer> customers=customerController.getAllCustomers();
		System.out.println("List of customers details :");

		for(Customer customer:customers) {
			
			System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getId());
		}
		/*
		 * System.out.println("Customers found with findAll():");
		 * System.out.println("-------------------------------");
		 * 
		 * for(Customer cust:customerRepository.findAll()) {
		 * System.out.println(cust.getId()+" "+ cust.getFirstName()+
		 * " "+cust.getLastName()); }
		 * 
		 * System.out.println("Enter the Customer Id to edit");
		 * 
		 * Scanner sc=new Scanner(System.in);
		 * 
		 * String custIn = sc.next();
		 * 
		 * 
		 * Optional<Customer> cust1 = customerRepository.findById(custIn);
		 * 
		 * System.out.println("Going to edit:"+cust1.get().getId());
		 * System.out.println("Enter the field which you want to edit");
		 * System.out.println("1.First Name"+ "  "+ "2.Last Name");
		 * 
		 * Integer editField = sc.nextInt();
		 * 
		 * UpdateUser(editField, cust1, sc);
		 */

	}
	
	public void UpdateUser(Integer editField,Optional<Customer> cust1,Scanner sc) {
    	
	    
    	if (editField == 1){
    		System.out.println("Provide the First Name you want to change");
    	
    		String custFirst= sc.next();
    	
    		Customer custFirstId = cust1.get();
    	
    		custFirstId.setFirstName(custFirst);
    	
    		//customerRepository.save(custFirstId);
    		System.out.println("First Name changed successfully");
    		
    	
    	}
    	else if (editField == 2) {
    			System.out.println("Provide the Last Name you want to change");
    	
    			String custLast= sc.next();
    			Customer custLastId = cust1.get();
    	
    			custLastId.setLastName(custLast);
    	
    			//customerRepository.save(custLastId);
    			System.out.println("Last Name changed successfully");
    	}
    	else {
    			System.out.println("Get the correct value (i.e. 1 or 2)");
    	
    			System.out.println("Enter the field which you want to edit");
    			System.out.println("1.First Name"+ "  "+ "2.Last Name");
	    
    			Integer editField1 = sc.nextInt();
	    
    			UpdateUser(editField1, cust1, sc);
    }
   }
    

}
