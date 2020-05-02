package com.example.demoDB.model;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private Integer userId;
	private String userType;
	private String name;
	private String emailId;
	private String phoneNo;
	
	public User() {
		super();
	}

	public User(String userType, String name, String emailId, String phoneNo) {
		super();
		this.userType = userType;
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
