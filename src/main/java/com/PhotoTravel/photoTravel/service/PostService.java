package com.PhotoTravel.photoTravel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.LikeDAO;
import com.PhotoTravel.photoTravel.DAO.PostDAO;
import com.PhotoTravel.photoTravel.DAO.TagDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.error.ResourceMalformedException;
import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.model.Post;
import com.PhotoTravel.photoTravel.model.PostDTO;
import com.PhotoTravel.photoTravel.model.Tag;
import com.PhotoTravel.photoTravel.model.User;

@Service
public  class PostService {

	private PostDAO postDAO;
	private UserService userService;
	private LikeDAO likeDAO;
	private TagDAO tagDAO;
	
	@Autowired
	public PostService(PostDAO postDAO,UserService userService, LikeDAO likeDAO) {
		this.postDAO = postDAO;
		this.userService = userService;
		this.likeDAO = likeDAO;
	}
	
	
	public Post addPost(PostDTO post,String userNick) {
		
		userService.findUserExists(userNick);
		User user = userService.getUserByNick(userNick);		
		if(post.getImageUrl() ==  null || post.getTags() == null) {
			throw new ResourceMalformedException("Dados_de_post_inválidos");
		}
		
		Post newPost = new Post(user, post.getImageUrl(),getTagsDB(post.getTags()));		
		return postDAO.save(newPost);
	}
	
	private List<Tag> getTagsDB(List<String> tags) {
		List<Tag> exit  = new ArrayList<Tag>();

		for (String tag : tags) {
			 Tag t= tagDAO.findById(tag).get();
			 if (t != null) {
				 exit.add(t);
			 }
			 
		}
		
		return exit;
	}
	
	public Post getPost(long id){
		
		findPostExists(id);
		return postDAO.findById(id).get();
	}
	
	public Like addLike(long postId, String userNick){
		Post post = getPost(postId);
		Like newLike = new Like(userNick , post);
		return likeDAO.save(newLike);
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
