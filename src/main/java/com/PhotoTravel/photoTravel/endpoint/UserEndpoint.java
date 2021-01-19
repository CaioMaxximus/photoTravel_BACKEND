package com.PhotoTravel.photoTravel.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.service.UserService;

@RestController
@ResponseBody
@RequestMapping("users")
public class UserEndpoint {

	
	@Autowired
	UserService service;
	
	@GetMapping("/{id}")
	public User getUserId(@PathVariable int id) {
		return new User("Caio" ,"Max@gmail.com");
		
	}
	
	@GetMapping("/search/{nick}")
	public User searchUsers() {
		return null;
	}
	
	
	
	
	@PostMapping("")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User exit = service.addUser_(user);
		if(exit != null) {
			return new ResponseEntity<User>(exit, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteUser(){
		return null;
	}
	
	
}
