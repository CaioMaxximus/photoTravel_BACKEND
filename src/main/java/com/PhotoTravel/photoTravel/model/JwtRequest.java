package com.PhotoTravel.photoTravel.model;

import java.io.Serializable;

public class JwtRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6567575785983313866L;
	private String nickname;
	private String password;

	public JwtRequest() {
			
	}
	
	public JwtRequest(String nickname , String password) {
		this.nickname = nickname;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
