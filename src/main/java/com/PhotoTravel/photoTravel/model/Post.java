package com.PhotoTravel.photoTravel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnore
	@ManyToOne
	private User ownerUser;
	private String imageUrl;
//	private List<String> tags;
	private String tags;
	private Date creationDate; /// Substituir pelo gregorian calendar
	@OneToMany(mappedBy = "post")
	private List<Like> likes;

	public Post(User ownerUser, String imageUrl, List<String> tags) {

		this.ownerUser = ownerUser;
		this.imageUrl = imageUrl;
		this.tags = "";
		this.likes = new ArrayList<Like>();

	}
	
	public Post(String imageUrl, List<String> tags) {

		this.imageUrl = imageUrl;
		this.tags = "";
		this.likes = new ArrayList<Like>();

	}
	
	
	
	public Post() {
		
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

}
