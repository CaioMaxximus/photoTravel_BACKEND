package com.PhotoTravel.photoTravel.service;

import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.model.User;;

@Service
public class UserService {

	
	public User getUser() {
		return new User("","");
	}
	
	
}
