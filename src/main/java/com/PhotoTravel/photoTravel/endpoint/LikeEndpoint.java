package com.PhotoTravel.photoTravel.endpoint;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody()
@RequestMapping("like")
public class LikeEndpoint {

	//production
	@GetMapping("")
	public void getLike() {
		
	}
	@PostMapping("")
	public void addLike() {
		
	}
	
	@DeleteMapping("")
	public void removeLike() {
		
	}
	
}
