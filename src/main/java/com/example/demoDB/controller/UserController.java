package com.example.demoDB.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import com.example.demoDB.model.User;
import com.example.demoDB.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	

	public void addUser(Integer type,Scanner sc) {
		// TODO Auto-generated method stub
		
		if(type==1) {
			System.out.println("Please enter the customer details :");
			System.out.print("Customer Id : ");
			Integer custId=sc.nextInt();	
			System.out.println();
			System.out.print("Customer First Name : ");
			String custfirstName=sc.next();
			System.out.println();
			System.out.print("Customer Last Name : ");
			String custlastName=sc.next();

			System.out.println();
			System.out.print("Customer email address : ");
			String custEmail=sc.next();
			System.out.println();
			System.out.print("PhoneNumber : ");
			String phoneNumber=sc.next();
			System.out.println();
			User customer=new User();
			customer.setUserId(custId);
			customer.setUserType("Customer");
			customer.setName(custfirstName+" "+custlastName);
			customer.setEmailId(custEmail);
			customer.setPhoneNo(phoneNumber);
			
			addCustomer(customer);
			
		}
		else if(type==2) {
			System.out.println("Please enter the Merchant details :");
			System.out.print("Merchant Id : ");
			Integer merId=sc.nextInt();		
			System.out.println();
			System.out.print("Merchant First Name : ");
			String merfirstName=sc.next();
			System.out.println();
			System.out.print("Merchant Last Name : ");
			String merlastName=sc.next();

			System.out.println();
			System.out.print("Merchant email address : ");
			String merEmail=sc.next();
			System.out.println();
			System.out.print("PhoneNumber : ");
			String phoneNumber=sc.next();
			System.out.println();
			
			User merchant=new User();
			merchant.setUserId(merId);
			merchant.setUserType("Merchant");
			merchant.setName(merfirstName+" "+merlastName);
			merchant.setEmailId(merEmail);
			merchant.setPhoneNo(phoneNumber);
			
			addMerchant(merchant);

		}
		else
		{
			System.out.println("Invalid User Type");
		}
	}


	public void addCustomer(User customer) {
		try {
			userService.addUser(customer);
			System.out.println(environment.getProperty("UserInterface.CUSTOMER_ADDED_SUCCES")+" "+customer.getUserId());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(environment.getProperty(e.getMessage()));
			Scanner sc=new Scanner(System.in);
			if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_UserID"))) {
				System.out.println("Please enter the correct customer Id");
			    Integer custId=sc.nextInt();
			    customer.setUserId(custId);

			    addCustomer(customer);
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_Email"))) {
				System.out.println("Please enter the correct email address");
				String custEmail=sc.next();
			    customer.setEmailId(custEmail);
			    addCustomer(customer);
				
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_Name"))) {
				System.out.println("Please enter the name");
				String custfirstName=sc.next();
				String custlastName=sc.next();
			    customer.setName(custfirstName+" "+custlastName);
			    addCustomer(customer);
				
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_PhoneNumber"))) {
				System.out.println("Please enter the phone number");
				String phoneNumber=sc.next();
			    customer.setPhoneNo(phoneNumber);
			    addCustomer(customer);
				
			}
			else {
				System.out.println("Invalid error");
			}
		}

	}
	
	public void addMerchant(User merchant) {
		try {
			userService.addUser(merchant);
			System.out.println(environment.getProperty("UserInterface.MERCHANT_ADDED_SUCCESS")+" "+merchant.getUserId());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(environment.getProperty(e.getMessage()));
			Scanner sc=new Scanner(System.in);
			if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_UserID"))) {
				System.out.println("Please enter the correct customer Id");
			    Integer merId=sc.nextInt();
			    merchant.setUserId(merId);

			    addMerchant(merchant);
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_Email"))) {
				System.out.println("Please enter the correct email address");
				String merEmail=sc.next();
				merchant.setEmailId(merEmail);
				addMerchant(merchant);
				
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_Name"))) {
				System.out.println("Please enter the name");
				String merfirstName=sc.next();
				String merlastName=sc.next();
				merchant.setName(merfirstName+" "+merlastName);
				addMerchant(merchant);
				
			}
			else if(environment.getProperty(e.getMessage()).equalsIgnoreCase(environment.getProperty("UserValidator.INVALID_PhoneNumber"))) {
				System.out.println("Please enter the phone number");
				String phoneNumber=sc.next();
				merchant.setPhoneNo(phoneNumber);
				addMerchant(merchant);
				
			}
			else {
				System.out.println("Invalid error");
			}
		}

	}
	
	public void listUsers(String userType) {
		
		
		List<User> users=userService.getUsers(userType);
		

		System.out.println("Id\tName\tEmail\tPhoneNumber\t");
		System.out.println("==================================================");
		for(User user:users) {
			System.out.println(user.getUserId()+"\t"+user.getName()+"\t"+user.getEmailId()+"\t"+user.getPhoneNo());
		}
		// TODO Auto-generated method stub
		
	}

	public void modifyUserDetail(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("Please select the field which you want to modify :\n1: Name\n2: Email\n3: PhoneNumber");
		Scanner sc=new Scanner(System.in);
		int f=sc.nextInt();
		if(f==1) {
			System.out.print("Enter the name :");
			String fName=sc.next();
			String lname=sc.next();
			String name=fName+" "+lname;
			System.out.println();
			modifyUserName(id,name);
			
		}
		else if(f==2) {
			System.out.print("Enter the email : ");
			String email=sc.next();
			System.out.println();
			
			modifyUserEmail(id,email);
		}
		else if(f==3) {
			System.out.print("Enter the phoneNumber :");
			String phoneNumber=sc.next();
			System.out.println();
			modifyUserPhoneNumber(id,phoneNumber);
		}
		else {
			System.out.println("Please select the valid option again");
			modifyUserDetail(id);
		}
		
		
	}


	private void modifyUserPhoneNumber(Integer id, String phoneNumber) {
		// TODO Auto-generated method stub
		try {
			String msg=userService.modifyUserPhoneNumber(id,phoneNumber);
			System.out.println(msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(environment.getProperty(e.getMessage()));
			Scanner sc=new Scanner(System.in);

			System.out.print("Re-enter the correct phone Number : ");
			phoneNumber=sc.next();
			System.out.println();
			modifyUserPhoneNumber(id,phoneNumber);


		}

	}


	private void modifyUserEmail(Integer id, String email) {
		// TODO Auto-generated method stub
		try {
			String msg=userService.modifyUserEmail(id,email);
			System.out.println(msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(environment.getProperty(e.getMessage()));
			Scanner sc=new Scanner(System.in);
			System.out.print("Re-enter the correct email : ");
			email=sc.next();
			System.out.println();
			modifyUserEmail(id,email);

		}

	}


	private void modifyUserName(Integer id, String name) {
		// TODO Auto-generated method stub
		try {
			String msg=userService.modifyUserName(id,name);
			System.out.println(msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(environment.getProperty(e.getMessage()));
			Scanner sc=new Scanner(System.in);
			System.out.print("Please re-enter the name :");
			String fName=sc.next();
			String lname=sc.next();
			name=fName+" "+lname;
			System.out.println();
			modifyUserName(id,name);

		}

	}

}
