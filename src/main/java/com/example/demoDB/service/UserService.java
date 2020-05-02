package com.example.demoDB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoDB.model.User;
import com.example.demoDB.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void addUser(User customer) {
		// TODO Auto-generated method stub
		userRepository.save(customer);
	}

	public List<User> getUsers(String userType) {
		// TODO Auto-generated method stub
		
		List<User> users=userRepository.findAll();
		List<User> newlist=new ArrayList<>();
		if(users.isEmpty()) {
				System.out.println("No "+userType+" Details Found");
			}
		else {
		for(User user:users) {
			if(user.getUserType().equalsIgnoreCase(userType))
				newlist.add(user);
				}
			}
		return newlist;
	}

	public String modifyUserName(Integer id, String name) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		String message=null;
		if(!user.isEmpty()) {
			User user2=user.get();
			
			user2.setName(name);
			userRepository.save(user2);
			message=user2.getUserType()+" Name is updated successfully for id : "+user2.getUserId();
			return message;
		}
		else {
			message="No data Found for Id "+id;
			return message;
		}
			
	}

	public String modifyUserEmail(Integer id, String email) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		String message=null;
		if(!user.isEmpty()) {
			User user2=user.get();
			
			user2.setEmailId(email);
			userRepository.save(user2);
			message=user2.getUserType()+" email address is updated successfully for id : "+user2.getUserId();
			return message;
		}
		else {
			message="No data Found for Id "+id;
			return message;
		}
	}

	public String modifyUserPhoneNumber(Integer id, String phoneNumber) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		String message=null;
		if(!user.isEmpty()) {
			User user2=user.get();
			
			user2.setPhoneNo(phoneNumber);
			userRepository.save(user2);
			message=user2.getUserType()+" phoneNumber is updated successfully for id : "+user2.getUserId();
			return message;
		}
		else {
			message="No data Found for Id "+id;
			return message;
		}
	}

}
