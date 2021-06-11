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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.service.PostService;

@RestController
@ResponseBody()
@RequestMapping("like")
public class LikeEndpoint {
	
	private PostService postService;

	@Autowired
	public LikeEndpoint(PostService postService) {
		this.postService = postService;
	}

	//production
	@GetMapping("")
	public void getLike() {
		
	}
	@PostMapping("/{userNick}/{postId}")
	public ResponseEntity<Like> addLike(@PathVariable long postId,@PathVariable String userNick) {
		return new ResponseEntity<Like>(postService.addLike(postId, userNick),HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public void removeLike() {
		
	}
	
}
