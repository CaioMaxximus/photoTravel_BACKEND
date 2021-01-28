package com.PhotoTravel.photoTravel.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.PhotoTravel.photoTravel.DAO.PostDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.model.Post;
public class PostService {


	private final PostDAO postDAO;
//	private final UserService userService;
	
	@Autowired
	public PostService(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	
	public Post addPost(Post post) {
		
		
//		Post newPost = new Post(user, post.imageUrl,post.tags)
		
		return null;
	}
	
	
	public Post getPost(long id){
		
		return null;
	}
	public void addLike(){
		
	}
	
	private void findPostExists(long id){
		if (!postDAO.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Post id dont exists");
		}
	}
	
//	
//	public void findUserAlreadyExists(String nick) {
//		if (postDAO.findById(id).isPresent()) {
//			throw new ResourceAlreadyExistsException("User nick already exists");
//		}
//
//	}
	
}
