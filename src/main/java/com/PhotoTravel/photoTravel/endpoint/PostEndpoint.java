package com.PhotoTravel.photoTravel.endpoint;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.service.PostService;;


@RestController
@RequestMapping("posts")
@ResponseBody
public class PostEndpoint {
	
	@Autowired
	PostService service;

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable int id) {
		return new ResponseEntity<Post>(service.getPost(id) ,HttpStatus.OK);
	}

	@GetMapping("/search/{}}")
	public List<Post> getPosts(){
		return new ArrayList<Post>();
	}
	
	@DeleteMapping("")
	public Post removePost(){
		return new Post();
	}
	
	@PostMapping("/{nick}")
	public ResponseEntity<Post> addPost(@PathVariable String nick, @RequestBody Post post) {
		return new ResponseEntity<Post> (service.addPost(post, nick),HttpStatus.OK);
	}
	
	@PutMapping("/report")
	public  void reportPost() {
		
	}
	
}
