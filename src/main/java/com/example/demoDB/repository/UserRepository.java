package com.example.demoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoDB.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
