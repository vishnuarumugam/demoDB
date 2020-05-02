package com.example.demoDB.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demoDB.model.User;
import com.example.demoDB.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
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
			
			userService.addUser(customer);
			System.out.println("Customer Details added succesfully! "+custId);
			
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
			
			userService.addUser(merchant);
			System.out.println("Merchant Details added succesfully! "+merId);

		}
		else
		{
			System.out.println("Invalid User Type");
			System.out.println("Please enter the correct userType");
			type=sc.nextInt();
			addUser(type, sc);
		}
	}

	public void listUsers() {
		
		System.out.println("Enter the userType which you want to list :");
		Scanner sc=new Scanner(System.in);
		String userType=sc.next();
		
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
		String msg=null;
		if(f==1) {
			System.out.print("Enter the name :");
			String fName=sc.next();
			String lname=sc.next();
			String name=fName+" "+lname;
			System.out.println();
			msg=userService.modifyUserName(id,name);
			System.out.println(msg);
		}
		else if(f==2) {
			System.out.print("Enter the email : ");
			String email=sc.next();
			System.out.println();
			
			msg=userService.modifyUserEmail(id,email);
			System.out.println(msg);
		}
		else if(f==3) {
			System.out.print("Enter the phoneNumber :");
			String phoneNumber=sc.next();
			System.out.println();
			
			msg=userService.modifyUserPhoneNumber(id,phoneNumber);
			System.out.println(msg);
		}
		else {
			System.out.println("Please select the valid option again");
			modifyUserDetail(id);
		}
		
		
	}

}
