package com.example.demoDB.model;

import org.springframework.data.annotation.Id;

public class Item {

	@Id
	private Integer itemID;
	private String itemName;
	private String itemDescription;
	private Double  itemPrice;
	private Integer itemQuantity;
	private Integer merchantId;
	
	
	
	public Item() {
		super();
	}



	public Item(String itemName, String itemDescription, Double itemPrice, Integer itemQuantity, Integer merchantId) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.merchantId = merchantId;
	}



	public Integer getItemID() {
		return itemID;
	}



	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getItemDescription() {
		return itemDescription;
	}



	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}



	public Double getItemPrice() {
		return itemPrice;
	}



	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}



	public Integer getItemQuantity() {
		return itemQuantity;
	}



	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	public Integer getMerchantId() {
		return merchantId;
	}



	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	
	
	
	
}
