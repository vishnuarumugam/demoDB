package com.example.demoDB.validator;

import java.util.regex.Pattern;

import com.example.demoDB.model.Item;
import com.example.demoDB.model.User;

public class ItemValidator {
	
	
	public static void validateItem(Item item) throws Exception{
		if(!ItemNameValid(item.getItemName())) {
			throw new Exception("ItemValidator.INVALID_Item_Name");
		}
		if(!ItemDescriptionValid(item.getItemDescription())) {
			throw new Exception("ItemValidator.INVALID_Item_Price");
		}
		if(!ItemPriceValid(item.getItemPrice())) {
			throw new Exception("ItemValidator.INVALID_Item_Quantity");
		}
		if(!ItemQuantityValid(item.getItemQuantity())){
			throw new Exception("ItemValidator.INVALID_Item_Description");
		}
	}
	public static Boolean ItemNameValid(String itemName) {
		
		Boolean isValid = true;
		
		return isValid;
	}
	
	public static Boolean ItemDescriptionValid(String itemDesc) {
		Boolean isValid = true;
		
		return isValid;
	}
	
	public static Boolean ItemPriceValid(Double itemPrice) {
		if(itemPrice!= null || itemPrice!=0) {
			return true;
		}
		return false;
	}
	
	public static Boolean ItemQuantityValid(Integer itemQuan) {
		if(itemQuan!= null || itemQuan!=0) {
			return true;
		}
		return false;
	}

	/*
	
	
	public static void validate(User user) throws Exception {
		if(!validateUserId(user.getUserId())) {
			throw new Exception("UserValidator.INVALID_UserID");

		}
		if(!validateUserEmail(user.getEmailId())) {
			throw new Exception("UserValidator.INVALID_Email");

		}
		if(!validateUserName(user.getName())) {
			throw new Exception("UserValidator.INVALID_Name");

		}
		if(!validateUserPhoneNumber(user.getPhoneNo())) {
			throw new Exception("UserValidator.INVALID_PhoneNumber");

		}
	}

	public static boolean validateUserPhoneNumber(String phoneNo) {
		// TODO Auto-generated method stub
		
		if(phoneNo!= null && phoneNo.length()==10) {
			return true;
		}
		return false;
	}

	public static boolean validateUserName(String name) {
		// TODO Auto-generated method stub
		if(name==null)
			return false;
		else
		{
			if(name.length()>=6)
				return true;
		}
		
		return false;
	}

	public static boolean validateUserEmail(String emailId) {
		// TODO Auto-generated method stub
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
		
		Pattern pattern=Pattern.compile(emailRegex);
		if(emailId==null)
			return false;
			
		return pattern.matcher(emailId).matches();
	}

	public static boolean validateUserId(Integer userId) {
		// TODO Auto-generated method stub

		Boolean flag=false;
		Integer count=0;
		if(userId>0)
		{
			while(userId !=0)
			{
				count++;
				userId=userId/10;
			}
			
		}
		if(count >= 3 && count <=8)
			flag=true;
		else
			flag=false;
		
		return flag;
	}*/
}
