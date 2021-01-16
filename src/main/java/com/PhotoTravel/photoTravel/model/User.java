package com.PhotoTravel.photoTravel.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	
	private String nickName;
	private String email;

	public User(String nickName , String email) {
		this.nickName = nickName;
		this.email = email;
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
