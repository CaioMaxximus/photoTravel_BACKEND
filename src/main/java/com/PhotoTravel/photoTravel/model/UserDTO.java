package com.PhotoTravel.photoTravel.model;

public class UserDTO {

	
	private String nickname;
	private String description;

	public UserDTO(User user) {
		
		this.nickname = user.getEmail();
		this.description = user.getDescription();
		
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
