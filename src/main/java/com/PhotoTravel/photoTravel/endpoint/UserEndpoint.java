package com.PhotoTravel.photoTravel.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.model.UserDTO;
import com.PhotoTravel.photoTravel.service.UserService;

@RestController
@ResponseBody
@RequestMapping("users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserEndpoint {

	
	@Autowired
	UserService service;
	
	
//	@GetMapping("/{id}")
//	public User getUserId(@PathVariable Long id) {
//		return service.getUser(id);
//		
//	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return new ResponseEntity(service.getAllUsers(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/personal")
	public ResponseEntity<User> getPersonaUserAcconut(@RequestHeader("Authorization") String token){
		return new ResponseEntity<User>(service.getPersonalUser(token), HttpStatus.OK); 
	}
	
	@GetMapping("/search/{nick}/short")
	public ResponseEntity<User> searchUsersShort(@PathVariable String nick) {
		return new ResponseEntity(service.getUserByNickDTOShort(nick),HttpStatus.OK);
	}

	@GetMapping("/search/{nick}/long")
	public ResponseEntity<User> searchUsersLong(@PathVariable String nick) {
		return new ResponseEntity(service.getUserByNickDTOLong(nick),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user){
		
		return new ResponseEntity<UserDTO>(service.addUser(user),HttpStatus.OK);
		
	}
	
	@PostMapping("/test")
	public ResponseEntity<User> addUseTest(@RequestBody User user){
		return new ResponseEntity<User>(service.addUser_(user),HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteUser(){
		return null;
	}
	
	
}
