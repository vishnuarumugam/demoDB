package com.example.demoDB.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demoDB.DemoDbApplication;
import com.example.demoDB.model.DatabaseSequence;
import com.example.demoDB.model.Item;
import com.example.demoDB.service.ItemService;
import com.example.demoDB.service.SequenceGeneratorService;

@Controller
public class ItemController {

	@Autowired 
	ItemService itemService;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	DemoDbApplication demoDbApplicaton;
	
	Integer merchantId;
	
	public List<Item> getAllItem(){
		
		List<Item> item = itemService.getAllItem();
		
		return item;
	}
	
	//Method to display the list of items
	public void ListItems() {
		
		List<Item> item=getAllItem();
		
		System.out.println("List of Item available :");
		
		for (Item items:item) {
			
			System.out.println("============================================");
			System.out.println("ID:" + items.getItemID());
			System.out.println("Name:" + items.getItemName());
			System.out.println("Description:" + items.getItemDescription());
			System.out.println("Price:" + items.getItemPrice());
			System.out.println("Quantity:"+ items.getItemQuantity());
			System.out.println("MerchantId:" + items.getMerchantId());

		}
		System.out.println("============================================");
	}
	
	public void ChangeItems(Integer merchantIdIn) {
		
		merchantId = merchantIdIn;
		
		System.out.println("Please select the options available:");
		System.out.println("1. Add New Item");
		System.out.println("2. Modify the existing Item");
		System.out.println("3. Delete the existing Item");
		System.out.println("4. Go Back");
		
		Scanner sc = new Scanner(System.in);
		
		Integer userIn = sc.nextInt();
		
		if (userIn == 1) {
			AddItemOption();
		}
		else if(userIn == 2) {
			ModifyItem(userIn);
		}
		else if (userIn == 3) {
			ModifyItem(userIn);
		}
		else if(userIn == 4) {
			//demoDbApplicaton.selectactionForMerchant();
		}
		else {
			System.out.println("Please select a valid option");
			ChangeItems(merchantId);
		}
		
	}
	
	public void AddItemOption() {
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please provide the below necessary details");
		
		
		System.out.println("Please enter the ID for the Item to added");
		Integer userItemID = sc.nextInt();
	
		System.out.println("Please enter the name of the Item to added");
		String userItemName = sc.next();

		System.out.println("Please enter the description which has to be diplayed for the Item");
		String userItemDesc = sc.next();
				
		System.out.println("Please enter the price of the Item");
		Double userItemPrice = sc.nextDouble();
		
		System.out.println("Please enter the no.of.quantity available");
		Integer userItemQuan = sc.nextInt();
		
		//Long itemSeq = sequenceGeneratorService.generateSequence(Item.Sequence_Name);
		
		//System.out.println("seq:" + itemSeq);
		Item item = new Item();
		
		item.setItemID(userItemID);
		item.setItemName(userItemName);
		item.setItemDescription(userItemDesc);
		item.setItemPrice(userItemPrice);
		item.setItemQuantity(userItemQuan);
		item.setMerchantId(merchantId);
		
		itemService.AddItem(item);
		
		System.out.println("Item added successfully");
		
		System.out.println("Do you want to continue adding. Please enter (y/n)");
		String userConIn = sc.next();
		
		if (userConIn.equalsIgnoreCase("y")){
			AddItemOption();
		}
		else {
			ChangeItems(merchantId);
		}
		
	}
	
	
	public void ModifyItem(Integer userIn) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Below are the list of Items available :");
		ListItems();
		
			List<Item> item= itemService.getMerchantItem(merchantId);
			
			
			if (!item.isEmpty()){
				System.out.println("List of Item available :");
				
				for (Item items:item) {
					
					
					System.out.println("============================================");
					System.out.println("ID:" + items.getItemID());
					System.out.println("Name:" + items.getItemName());
					System.out.println("Description:" + items.getItemDescription());
					System.out.println("Price:" + items.getItemPrice());	
					System.out.println("Quantity:" + items.getItemQuantity());
				}
				if (userIn == 2) {
					System.out.println("Please enter ItemID which you want to Modify");
				}
				else {
					System.out.println("Please enter ItemID which you want to Delete");
				}
				
				Integer userItemIdIn = sc.nextInt();
				
				Item singleItem = ItemIDCheck(item, userItemIdIn);
					
				if (singleItem!=null) {
										
					if (userIn == 2) {
						ModifyEachItem(singleItem);
					}
					else {
						DeleteEachItem(singleItem);
					}
				
				}
				
			}
			
			else {
				System.out.println("No Items available. Do you want add new one? (y/n)");
				String userConIn = sc.next();
				
				if (userConIn.equalsIgnoreCase("y")){
					AddItemOption();
				}
				else {
					ChangeItems(merchantId);
				}
				
			}
	}
	
	public void DeleteEachItem(Item singleItem) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please confirm whether you want to delete the below Item:(y/n)");
		
		String userConIn = sc.next();
		
		if (userConIn.equalsIgnoreCase("y")){
			itemService.DeleteItem(singleItem);
		}
		else {
			ChangeItems(merchantId);
		}
		
		System.out.println("Item has been deleted successfully");
		
	}
	
public Item ItemIDCheck(List <Item> item, Integer userItemIdIn) {
		
		Scanner sc = new Scanner(System.in);
		
		Item singleItem = new Item();	
		
		Boolean itemIdCheck = itemService.CheckItem(userItemIdIn);
		
		if (itemIdCheck) {
			for (Item items:item) {
				if (items.getItemID()==userItemIdIn) {
					return items; 
				} 
			}
		}
		else {
			
			System.out.println("Please enter the valid ItemID"); 
			
			Integer userIn = sc.nextInt();
			
			ItemIDCheck(item, userIn);
			
		}
		
		/*
		 * for (Item items:item) {
		 * 
		 * if (items.getItemID()==userItemIdIn) { return items; } }
		 */
		return singleItem;
	}
	
	public void ModifyEachItem(Item singleItem) {
		
		Scanner sc = new Scanner(System.in);
		
		String userItemName = null;
		String userItemDesc = null;
		Double userItemPrice = null;
		Integer userItemQuan = null;
		System.out.println("Please enter the field you want to modify");
		System.out.println("1. Item Name");
		System.out.println("2. Item Description");
		System.out.println("3. Item Price");
		System.out.println("4. Item Quantity");
		System.out.println("5. Go Back");
		
		Item item = singleItem;
		
		Integer userItemIn = sc.nextInt();		
		
		if (userItemIn == 1) {
			System.out.println("Please enter the new name for the item");
			userItemName = sc.next();
			item.setItemName(userItemName);
		}
		
		else if (userItemIn == 2) {
			System.out.println("Please enter the new description for the Item");
			userItemDesc = sc.next();
			item.setItemDescription(userItemDesc);
		}
		
		else if(userItemIn == 3) {
			System.out.println("Please enter the new price of the Item");
			userItemPrice = sc.nextDouble();
			item.setItemPrice(userItemPrice);
		}
		else if(userItemIn == 4) {
			System.out.println("Please enter the no.of.quantity available");
			userItemQuan = sc.nextInt();
			item.setItemQuantity(userItemQuan);
			
		}
		else if(userItemIn == 5) {
			ChangeItems(merchantId);
		}
				
		else {
			System.out.println("Please enter the valid option");
			ModifyEachItem(singleItem);
			
		}
		
		
		itemService.AddItem(item);
		
		System.out.println("Item modified successfully");
		
			System.out.println("Modified Item Details");
			System.out.println("============================================");
			System.out.println("ID:" + singleItem.getItemID());
			System.out.println("Name:" + singleItem.getItemName());
			System.out.println("Description:" + singleItem.getItemDescription());
			System.out.println("Price:" + singleItem.getItemPrice());	
			System.out.println("Quantity:" + singleItem.getItemQuantity());
			System.out.println("============================================");

		
		System.out.println("Do you want to continue modifying. Please enter (y/n)");
		String userConIn = sc.next();
		
		if (userConIn.equalsIgnoreCase("y")){
			ModifyEachItem(singleItem);
		}
		else {
			ChangeItems(merchantId);
		}
	}
	
}
