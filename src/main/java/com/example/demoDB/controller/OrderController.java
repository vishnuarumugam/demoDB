package com.example.demoDB.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demoDB.model.Item;
import com.example.demoDB.model.Order;
import com.example.demoDB.model.OrderItem;
import com.example.demoDB.service.ItemService;
import com.example.demoDB.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired 
	ItemController itemController;
	@Autowired
	ItemService itemService;
	
	List <OrderItem> items = new ArrayList<>();
	Double orderTotalPrice = 0.0;
	Long orderId = null;
	
	public void placeOrder() {
		displayItem();
		
		System.out.println("Please enter the ItemId to order");
		addOrder();
		
		
		
	}
	
	public void displayItem() {
		
		
		List<Item> item = itemController.getAllItem();
		
		for (Item items:item) {
			
			if (items.getItemQuantity()>0) {
				System.out.println("============================================");
				System.out.println("ID:" + items.getItemID());
				System.out.println("Name:" + items.getItemName());
				System.out.println("Description:" + items.getItemDescription());
				System.out.println("Price:" + items.getItemPrice());
				System.out.println("Quantity:"+ items.getItemQuantity());
				System.out.println("MerchantId:" + items.getMerchantId());
			}
			

		}
		System.out.println("============================================");
	}
	
	public void addOrder() {
		List<Item> itemList = itemController.getAllItem();
		
		Scanner sc = new Scanner(System.in);
		
		Integer userIn = sc.nextInt();
		
		Item singleItem = itemController.ItemIDCheck(itemList, userIn);
		
		if (singleItem!=null) {
			
			
			System.out.println("Please enter the no.of quantity you need to order");
			Integer itemQuantity = quantityCheck(singleItem);
			
			if (itemQuantity != null) {
				
				
				singleItem.setItemQuantity(singleItem.getItemQuantity()-itemQuantity);
				itemService.modifyItem(singleItem);
				
				
				OrderItem orderItem = new OrderItem();
				
				orderItem.setItemId(singleItem.getItemID());
				orderItem.setItemPrice(singleItem.getItemPrice());
				orderItem.setItemQuantity(itemQuantity);
				orderItem.setItemTotalPrice(itemQuantity*singleItem.getItemPrice());
				items.add(orderItem);
				orderTotalPrice = orderTotalPrice + (itemQuantity*singleItem.getItemPrice());
				
				System.out.println("Do you like to continue ordering? (y/n)");
				placeFinalOrder();
				
			}
			
		}
	}
	
	public Integer quantityCheck(Item singleItem) {
		Scanner sc = new Scanner(System.in);
		
		Integer userQuanIn = sc.nextInt();
		
		if (userQuanIn<=singleItem.getItemQuantity()) {
			return userQuanIn;
		}
		else {
			System.out.println("Sorry, we have only " +singleItem.getItemQuantity()+ " no. of.quantity please order within available quantity");
			quantityCheck(singleItem);
		}
		
		return null;
	}
	public void placeFinalOrder() {
		
		Scanner userConSc = new Scanner(System.in);
		
		String userCon = userConSc.next();
		Order order = new Order();
		if (userCon.equalsIgnoreCase("n")) {
			generateOrderId();
			System.out.println("orderid" + orderId);
			order.setOrderId(orderId); 
			order.setMerchantId(1); 
			order.setCustomerId(2);
			order.setOrderTotalPrice(orderTotalPrice); 
			order.setOrderItem(items);
			 
			orderService.AddOrder(order);
			System.out.println("Order Placed");
		}
		else if (userCon.equalsIgnoreCase("y")){
			placeOrder();
		}
		
		else {
			System.out.println("Please enter valid option");
			placeFinalOrder();
		}
		
	}
	public Long generateOrderId() {
		
		
		return orderId = orderService.getOrderCount()+1;
	}


}
