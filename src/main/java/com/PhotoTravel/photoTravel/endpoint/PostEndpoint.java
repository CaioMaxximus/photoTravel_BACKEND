package com.PhotoTravel.photoTravel.endpoint;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.model.Post;;


@RestController
@RequestMapping("posts")
@ResponseBody
public class PostEndpoint {

	@GetMapping("/{id}")
	public ResponseEntity<?> getPost(@PathVariable int id) {
		return new ResponseEntity<Post>(new Post(),HttpStatus.OK);
	}

	@GetMapping("/search/{}}")
	public List<Post> getPosts(){
		return new ArrayList<Post>();
	}
	
	@DeleteMapping("")
	public Post removePost(){
		return new Post();
	}
	
	@PutMapping("/report")
	public  void reportPost() {
		
	}
	
}
