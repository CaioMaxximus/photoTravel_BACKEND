package com.PhotoTravel.photoTravel.endpoint;

 import javax.mail.AuthenticationFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.configurations.JWTUtil;
import com.PhotoTravel.photoTravel.error.ResourceMalformedException;
import com.PhotoTravel.photoTravel.model.JwtRequest;
import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.service.UserService;

@CrossOrigin
@RestController
public class AuthenticationEndpoint {
	
	@Autowired
	UserService userService;
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthentication(@RequestBody JwtRequest req) throws Exception{
		authenticate(req.getNickname(), req.getPassword());
		System.out.println("Entrou pra login");
		
		return new ResponseEntity<String>(jwtUtil.generateToken(req),HttpStatus.OK);
	}
	
	
	private void authenticate(String nickname, String password) throws Exception{
		
		if(nickname == null || password == null ) {
			throw new ResourceMalformedException("Invalid Data");
		}else{
			User user = userService.getUserByNick(nickname);
			System.out.println(password); 
			if(!user.getPassword().equals(password) ) {
				throw new AuthenticationFailedException("Invalid Password");
			}
			
		}
		
	}
}
