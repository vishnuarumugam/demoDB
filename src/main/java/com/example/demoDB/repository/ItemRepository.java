package com.example.demoDB.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoDB.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, Integer>{
	
	public List <Item> findByMerchantId(Integer merchantId);
}
