package com.example.demoDB.model;

public class OrderItem {
	
	Integer itemId;
	Double itemPrice;
	Double itemTotalPrice;
	Integer itemQuantity;

	
	public OrderItem(Integer itemId,Double itemPrice,Double itemTotalPrice,Integer itemQuantity) {
		
		super();
		
		this.itemId=itemId;
		this.itemPrice=itemPrice;
		this.itemTotalPrice=itemTotalPrice;
		this.itemQuantity=itemQuantity;
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
