package com.PhotoTravel.photoTravel.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.configurations.JWTUtil;
import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.service.PostService;

@RestController
@ResponseBody()
@RequestMapping("like")
public class LikeEndpoint {
	
	
	private PostService postService;
	private JWTUtil jwtUtil;
	
	@Autowired
	public LikeEndpoint(PostService postService , JWTUtil jwtUtil) {
		this.postService = postService;
		this.jwtUtil = jwtUtil;
	}

	//production
	@GetMapping("")
	public void getLike() {
		
	}
	@PostMapping("/{postId}")
	public ResponseEntity<Like> addLike(@PathVariable long postId,@RequestHeader String authorization) {
		String nickname = jwtUtil.getUserNameFromHeader(authorization);
		return new ResponseEntity<Like>(postService.addLike(postId, nickname),HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public void removeLike() {
		
	}
	
}
