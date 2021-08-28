package com.PhotoTravel.photoTravel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.LikeDAO;
import com.PhotoTravel.photoTravel.DAO.PostDAO;
import com.PhotoTravel.photoTravel.DAO.TagDAO;
import com.PhotoTravel.photoTravel.DAO.UserDAO;
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
	private UserDAO userDAO;
	
	@Autowired
	public PostService(PostDAO postDAO,UserService userService, LikeDAO likeDAO , TagDAO tagDAO , UserDAO userDAO) {
		this.postDAO = postDAO;
		this.userService = userService;
		this.likeDAO = likeDAO;
		this.tagDAO = tagDAO;
		this.userDAO = userDAO;
	}
	
	
	public Post addPost(PostDTO post,String userNick) {
		
		userService.findUserExists(userNick);
		User user = userService.getUserByNick(userNick);		
		if(post.getImageUrl() ==  null || post.getTags() == null) {
			throw new ResourceMalformedException("Dados_de_post_inválidos");
		}
		System.out.println(post.toString());
		
		Post newPost = new Post(user, post.getImageUrl(),getTagsDB(post.getTags()));
		
		return postDAO.save(newPost);
	}
	
	private List<Tag> getTagsDB(List<String> tags) {
		List<Tag> exit  = new ArrayList<Tag>();

		for (String tag : tags) {
			System.out.println(tag);
			 Optional<Tag> t= tagDAO.findById(tag);
			 if (t.isPresent()) {
				 System.out.println(tag);
				 exit.add(t.get());
			 }else{
				 Tag newT = new Tag(tag);
				 tagDAO.save(newT);
				 newT.toString();
				 exit.add(newT);
			 }
			 
			 
			 
		}
		
		return exit;
	}
	
	public Post getPost(long id){
		
		findPostExists(id);
		return postDAO.findById(id).get();
	}

	public List<Post> getPostsByNick(String userNick){

		userService.findUserExists(userNick);
		User user = userDAO.findById(userNick).get();
		List<Post> posts =  postDAO.findByOwnerUser(user);
		return posts;
	}
	
	public List<Post> getPosts(){
		return postDAO.findAll();
	}
	
	public Like addLike(long postId, String userNick){
		
		
		this.findPostExists(postId);
		userService.findUserExists(userNick);
		Post post = getPost(postId);
		Optional<Like> l = likeDAO.findByPostAndOwnerNick(post, userNick);
		if(l.isPresent()) {
			likeDAO.delete(l.get());
			return l.get();
		}else {
			Like newLike = new Like(userNick , post);
			return likeDAO.save(newLike);

		}
		
	}
	
	
	//Alterar para retornar o objeto para evitar consultas duplicadas no banco
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
