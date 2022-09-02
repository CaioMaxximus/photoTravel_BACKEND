package com.PhotoTravel.photoTravel.endpoint;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PhotoTravel.photoTravel.configurations.JWTUtil;
import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.model.PostDTO;
import com.PhotoTravel.photoTravel.service.PostService;;


@RestController
@RequestMapping("posts")
@ResponseBody
@CrossOrigin
public class PostEndpoint {
	
	@Autowired
	PostService service;
	@Autowired
	JWTUtil jwtUtil;

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable int id) {
		return new ResponseEntity<Post>(service.getPost(id) ,HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Post> getPosts(){
		return service.getPosts();
	}

	@GetMapping("/{userNick}/{order}")
	public ResponseEntity<List<Post>> getPostsFromUser(@PathVariable String userNick , @PathVariable String order){

		return new ResponseEntity<List<Post>> (service.getPostsByNick(userNick) ,HttpStatus.OK) ;
	}
	
	@DeleteMapping("")
	public Post removePost(){
		return new Post();
	}
	
	@PostMapping("")
	public ResponseEntity<Post> addPost( @RequestBody PostDTO post , @RequestHeader("Authorization") String header) {
		String nickname = jwtUtil.getUserNameFromHeader(header);
		return new ResponseEntity<Post> (service.addPost(post, nickname),HttpStatus.OK);
	}
	
	@PostMapping("/likes/{postId}")
	public ResponseEntity<Boolean> addLike(@PathVariable long postId,@RequestHeader("Authorization") String authorization) {
		System.out.println("chamou o endpoint");
		String nickname = jwtUtil.getUserNameFromHeader(authorization);
		return new ResponseEntity<Boolean>(service.addLike(postId, nickname),HttpStatus.OK);
	}
	
	//ver se desejo espor quem deu like para os outros usuarios
	@GetMapping("/likes/{postId}")
	public ResponseEntity<Like> getLikeByUserNick(@PathVariable long postId,@RequestHeader("Authorization") String authorization){

		String nickname = jwtUtil.getUserNameFromHeader(authorization);
		return new ResponseEntity<Like>(service.findLikeByNickAndPost(nickname , postId ), HttpStatus.OK);
	}
	
	@GetMapping("/search/tags/{tags}")
	public ResponseEntity<List<Post>> getPostsByTag(@PathVariable  String tags){
		return new ResponseEntity<List<Post>>(service.findPostsByTags(tags),HttpStatus.OK);
	}
	
	@PutMapping("/report")
	public  void reportPost() {
		
	}
	
}
