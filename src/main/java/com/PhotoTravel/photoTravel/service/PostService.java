package com.PhotoTravel.photoTravel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

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
		System.out.println(postDAO.findById(id).get());
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
	
	public List<Post> getPostsSorted(String method , int page) {
		
		return null;
		
	}
	public Boolean addLike(long postId, String userNick){
		this.findPostExists(postId);
		System.out.println("like nick" + userNick);
		userService.findUserExists(userNick);
		Post post = getPost(postId);
		System.out.println(post);
		Like like = likeDAO.findByPostAndOwnerNick(post, userNick);
		if(like != null
				) {
			post.removeLike(like);
			likeDAO.delete(like);
			postDAO.save(post);
			return false;
		}else {
			Like newLike = new Like(userNick , post);
			post.addLike(newLike);
			postDAO.save(post);
			return true;

		}
	
	}
	
	public Like findLikeByNickAndPost(String userNick , long postId) {
		this.findPostExists(postId);
		System.out.println("like nick" + userNick);
		userService.findUserExists(userNick);
		Post post = getPost(postId);
		Like like = likeDAO.findByPostAndOwnerNick(post, userNick);
		if(like == null) {
			throw new ResourceNotFoundException("Like dont exists");
		}
		System.out.println();
		return like;
	}
	
	//Alterar para retornar o objeto para evitar consultas duplicadas no banco
	private void findPostExists(long id){
		if (!postDAO.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Post id dont exists");
		}
	}

///Transformar metódo de ordenacao em um enum
	public List<Post> findPostsByTags(String tags, String method) {

		List<String> tagsList = Arrays.asList(tags.split(" "));
		String regexTags = "^(";
		
		for (int i = 0; i < tagsList.size(); i ++) {
			if(i == tagsList.size() -1) {
				regexTags += tagsList.get(i);
			}
			else{
				regexTags += tagsList.get(i) + "|";
			}
		}regexTags += ")$";
		System.out.println(regexTags);
		System.out.println(method);

		switch (method) {
		case "numLikes":
			return postDAO.findPostsByTagsSortedByLikes (regexTags);
		case "date":
			return postDAO.findPostsByTagsSortedByDate (regexTags);
			
		default:
			return new LinkedList<>();
			
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
