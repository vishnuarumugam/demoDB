package com.example.demoDB.model;

public class OrderItem {
	
	Integer itemId;
	String itemName;
	Integer itemMerchantId;
	Double itemPrice;
	Double itemTotalPrice;
	Integer itemQuantity;

	
	
	public OrderItem() {
		super();
	}


	public OrderItem(Integer itemId,Double itemPrice,Double itemTotalPrice,Integer itemQuantity, Integer itemMerchantId, String itemName) {
		
		super();
		
		this.itemId=itemId;
		this.itemPrice=itemPrice;
		this.itemTotalPrice=itemTotalPrice;
		this.itemQuantity=itemQuantity;
		this.itemName=itemName;
		this.itemMerchantId=itemMerchantId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Integer getItemMerchantId() {
		return itemMerchantId;
	}


	public void setItemMerchantId(Integer itemMerchantId) {
		this.itemMerchantId = itemMerchantId;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public Double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}


	public Double getItemTotalPrice() {
		return itemTotalPrice;
	}


	public void setItemTotalPrice(Double itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}


	public Integer getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
