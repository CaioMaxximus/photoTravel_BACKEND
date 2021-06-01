package com.PhotoTravel.photoTravel.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.PostDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.error.ResourceMalformedException;
import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.model.User;

@Service
public  class PostService {

	private PostDAO postDAO;
	private UserService userService;
	
	
	@Autowired
	public PostService(PostDAO postDAO,UserService userService) {
		this.postDAO = postDAO;
		this.userService = userService;
	}
	
	
	public Post addPost(Post post,String userNick) {
		
		System.out.println("user nick : " + userNick);
		userService.findUserExists(userNick);
		User user = userService.getUserByNick(userNick);
		System.out.println(user.toString());
		System.out.println(post.getImageUrl());
		if(post.getImageUrl() ==  null || post.getTags() == null) {
			throw new ResourceMalformedException("Dados_de_post_inválidos");
		}
		Post newPost = new Post(user, post.getImageUrl(),Arrays.asList(post.getTags().split(";", 1)));
		
		return newPost;
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
