package com.PhotoTravel.photoTravel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user_entity")
public class User {

	@Id
	private String nickname;
	@Column
	private String email;
	@Column
	private String description;
	
	@Column
	@JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	public User(String nickname, String email, String password ,String description) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.description = description;
	}

	public User() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return this.nickname + " " +  this.email + " " + this.description + " " + this.password;
	}

}
