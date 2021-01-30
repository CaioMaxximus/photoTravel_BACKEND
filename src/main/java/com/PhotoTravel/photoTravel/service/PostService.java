package com.PhotoTravel.photoTravel.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.PhotoTravel.photoTravel.DAO.PostDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.model.User;
public class PostService {


	private final PostDAO postDAO;
    private UserService userService;
	
	@Autowired
	public PostService(PostDAO postDAO,UserService userService) {
		this.postDAO = postDAO;
		this.userService = userService;
	}
	
	
	public Post addPost(Post post,String userNick) {
		
		userService.findUserExists(userNick);
		User user = userService.getUserByNick(userNick);
//		Post newPost = new Post(user, post.getImageUrl(),post.getTags());
		
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
