package com.example.demoDB;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoDB.controller.CustomerController;
import com.example.demoDB.controller.ItemController;
import com.example.demoDB.controller.OrderController;
import com.example.demoDB.controller.UserController;
import com.example.demoDB.model.Customer;

@SpringBootApplication
public class DemoDbApplication implements CommandLineRunner{

	@Autowired
	CustomerController customerController;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ItemController itemController;

	@Autowired
	OrderController orderController;

	
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
		
		/*
		 * List<Customer> customers=customerController.getAllCustomers();
		 * System.out.println("List of customers details :");
		 * 
		 * for(Customer customer:customers) {
		 * 
		 * System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "
		 * +customer.getId()); }
		 */		
		
		System.out.println("WelCome to Applications!..........");
		System.out.println("Select Options : \n1: User Data\n2: Item Data\n3:Order Data");
		Scanner sc = new Scanner(System.in);

		int opt=sc.nextInt();
		
		selectAppropriateAction(opt,sc);
		
		
		
		
		
		
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
	
	
	
	private void selectAppropriateAction(int opt, Scanner sc) {
		// TODO Auto-generated method stub
		if(opt==1) {
			System.out.println("Please select the options which you want to select");
			System.out.println("1: Add Customer/Merchant Details\n2: List Customer/Merchant Details\n3: Modify Customer/Merchant Details");

			int option=sc.nextInt();
			selectionCriteria(option,sc);
			
		}
		else if(opt==2) {
			//itemController.ListItems();
			itemController.ChangeItems();
			System.out.println("Do you want to continue again? y/n ");
			String flag=sc.next();

			if(flag.equalsIgnoreCase("y")) {
				System.out.println("Please Select the Options again : \n1: User Data\n2: Item Data\n3:Order Data");

				opt=sc.nextInt();
				selectAppropriateAction(opt, sc);
				
			}
			else
			{
				System.out.println("Action is Completed!.............");
			}
			
			
		}
		else if(opt==3) {
			orderController.placeOrder();
			System.out.println("Do you want to continue again? y/n ");
			String flag=sc.next();

			if(flag.equalsIgnoreCase("y")) {
				System.out.println("Please Select the Options again : \n1: User Data\n2: Item Data\n3:Order Data");

				opt=sc.nextInt();
				selectAppropriateAction(opt, sc);
				
			}
			else
			{
				System.out.println("Action is Completed!.............");
			}
	

		}
		else {
			System.out.println("Please enter the correct options");
			opt=sc.nextInt();
			selectAppropriateAction(opt, sc);
			
		}
	}

	private void selectionCriteria(int option,Scanner sc) {
		// TODO Auto-generated method stub
		
		if(option==1) {
			System.out.println("Add Customer/Merchant details");
			
			System.out.println("Choose 1 to add customer details and choose 2 to add merchant details");
			System.out.println("1: Customer \n2: Merchant ");
			Integer type=sc.nextInt();
			
			userController.addUser(type,sc);
			
			System.out.println("Do you want to try again? y/n ");
			String flag=sc.next();
			if(flag.equalsIgnoreCase("y")) {
			System.out.println("Please enter the options from below Lists :\n1: Add Customer/Merchant Details\n2: List Customer/Merchant Details\n3: Modify Customer/Merchant Details ");
			option=sc.nextInt();
			selectionCriteria(option, sc);
			}
			else {
				System.out.println("User Action is Completed!...........");
				System.out.println("Please Select the Options again : \n1: User Data\n2: Item Data\n3:Order Data");

				option=sc.nextInt();
				selectAppropriateAction(option, sc);

			}
			
		}
		else if(option==2) {
			System.out.println("Listing User details based on userType");
			userController.listUsers();		

			System.out.println("Do you want to try again? y/n ");
			String flag=sc.next();
			if(flag.equalsIgnoreCase("y")) {
			System.out.println("Please enter the options from below Lists :\n1: Add Customer/Merchant Details\n2: List Customer/Merchant Details\n3: Modify Customer/Merchant Details ");
			option=sc.nextInt();
			selectionCriteria(option, sc);
			}
			else {
				System.out.println("User Action is Completed!...........");
				System.out.println("Please Select the Options again : \n1: User Data\n2: Item Data\n3:Order Data");

				option=sc.nextInt();
				selectAppropriateAction(option, sc);

			}
			
		}
		
		else if(option==3) {
			System.out.println("Please enter the Id which you want to modify");
			Integer id=sc.nextInt();
			userController.modifyUserDetail(id);
			
			System.out.println("Do you want to try again? y/n ");
			String flag=sc.next();
			if(flag.equalsIgnoreCase("y")) {
			System.out.println("Please enter the options from below Lists :\n1: Add Customer/Merchant Details\n2: List Customer/Merchant Details\n3: Modify Customer/Merchant Details ");
			option=sc.nextInt();
			selectionCriteria(option, sc);
			}
			else {
				System.out.println("User Action is Completed!...........");
				System.out.println("Please Select the Options again : \n1: User Data\n2: Item Data\n3:Order Data");

				option=sc.nextInt();
				selectAppropriateAction(option, sc);

			}
		}
		else {
			System.out.println("Please enter the correct options");
			option=sc.nextInt();
			selectionCriteria(option, sc);
		}
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
