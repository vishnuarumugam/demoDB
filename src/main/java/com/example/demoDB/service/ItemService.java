package com.example.demoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoDB.model.Item;
import com.example.demoDB.repository.ItemRepository;
import com.example.demoDB.validator.ItemValidator;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
	public List<Item> getAllItem(){
		
		List<Item> item = itemRepository.findAll();
		
		return item;
	}
	
	public List<Item> getMerchantItem(Integer merchantID){
		List <Item> item = itemRepository.findByMerchantId(merchantID);
		
		return item;
	}
	
	public void AddItem(Item item) {
		
		
		
		if (ItemValidator.ItemNameValid(item.getItemName())) {
			
		}
		
		if (ItemValidator.ItemDescriptionValid(item.getItemDescription())) {
			
		}
		if (ItemValidator.ItemPriceValid(item.getItemPrice())) {
		
		}
		if (ItemValidator.ItemQuantityValid(item.getItemQuantity())) {
			
		}
		
		itemRepository.save(item);
		
	}
	public Boolean CheckItem(Integer userItemIdIn) {
		Boolean isExists = false;
		
		isExists = itemRepository.existsById(userItemIdIn);
		
		return isExists;
	}
	public void modifyItem(Item item) {
		itemRepository.save(item);
	}
	public void DeleteItem(Item item) {
		
		
		itemRepository.delete(item);
	}
	public Long getItemCount() {
		return itemRepository.count();
	}
}
