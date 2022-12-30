package com.PhotoTravel.photoTravel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
//	@JoinColumn(name = "nickname")
	private User ownerUser;
	private String imageUrl;
	@ManyToMany
	private List<Tag> tags;
	private Date creationDate; /// Substituir pelo gregorian calendar
//se tags forem compartuilhadas entre posts, deve -se repensar no método de remoção , se não se removerá as tags de outros posts
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private List<Like> likes;
	private long numLikes;

	public Post(User ownerUser, String imageUrl, List<Tag> tags) {

		this.ownerUser = ownerUser;
		this.imageUrl = imageUrl;
		this.tags = tags;
		this.likes = new ArrayList<Like>();
		creationDate = new Date();

	} 
 
	
	public Post(String imageUrl, List<Tag> tags) {

		this.imageUrl = imageUrl;
		this.tags = tags;
		this.likes = new ArrayList<Like>();

	}
	
	
	
	public Post() {
		
	}

	
	@JsonGetter("ownerUser")
	public String getOwnUser() { 
		return this.ownerUser.getNickname();
	}

	@JsonGetter("tags")
	public List<String> getStringTags(){
		List<String> saida = new ArrayList();
		for (Tag tag : this.tags) {
			
			saida.add(tag.getId());
		}
		return saida;
				
	}
	
	public long getNumLikes() {
		return numLikes;
	}

	public void setNumLikes(long numLikes) {
		this.numLikes = numLikes;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

//	public List<String> getTags() {
//		return tags;
//	}
//
//	public void setTags(List<String> tags) {
//		this.tags = tags;
//	}
	

	public Date getCreationDate() {
		return creationDate;
	}

	public Long getId() {
		return id;
	}

	
	public User getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Like> getLikes() {
		return Collections.unmodifiableList(this.likes);
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	public void addLike(Like like) {
		this.likes.add(like);
		this.numLikes += 1;
	}
	
	public void removeLike(Like like) {
		if(this.likes.remove(like)) {
			this.numLikes -= 1;}
		//lancar excecao
		
			
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getOwnUser() + " - " + this.getId();
	}

}
