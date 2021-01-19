package com.PhotoTravel.photoTravel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class User {

	@Id
	private String nickName;
	private String email;
	private String description;
	

	public User(String nickName , String email) {
		this.nickName = nickName;
		this.email = email;
		this.description = " ";
	}

	public User() {
		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
