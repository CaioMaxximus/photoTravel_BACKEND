package com.PhotoTravel.photoTravel.model;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

public class PostDTO {

	private List<String> tags;
	private String imageUrl;
	@Nullable
	private String creationDate; /// Substituir pelo gregorian calendar
	private String userNick;
	
	
	public PostDTO( List<String> tags , String imageUrl , String creationDate) {
	
		this.tags = tags;
		this.creationDate = creationDate;
		this.imageUrl = imageUrl;
	}
	
	public PostDTO( List<String> tags,  String imageUrl , String creationDate, String userNick ) {
		
		this.tags = tags;
		this.creationDate = creationDate;
		this.imageUrl = imageUrl;
		this.userNick = userNick;
	}
	
	
	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	
	
}
