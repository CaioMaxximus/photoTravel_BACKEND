package com.PhotoTravel.photoTravel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Post {

	
	private String ownerNick;
	private String imageUrl;
	private List<String> tags;
	private Date creationDate; /// Substituir pelo gregorian calendar
	private List<Like> likes;

	public Post(String ownerNick, String imageUrl, List<String> tags) {

		this.ownerNick = ownerNick;
		this.imageUrl = imageUrl;
		this.tags = tags;
		this.likes = new ArrayList<Like>();

	}
	
	public Post() {
		
	}

	public String getOwnerNick() {
		return ownerNick;
	}

	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Date getCreationDate() {
		return creationDate;
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
