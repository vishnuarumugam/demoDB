package com.example.demoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoDB.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

}
