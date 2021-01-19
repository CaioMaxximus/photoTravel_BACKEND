package com.PhotoTravel.photoTravel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Entity
public class Like {
	
	@Id
	public long id;
	private String ownerNick;
	private int postId;
	private  Date creationDate;

	public Like() {
		
	}
	
	public Like(String ownerNick ,int postId) {
		
		this.ownerNick = ownerNick;
		this.postId = postId;
	}

	public String getOwnerNick() {
		return ownerNick;
	}

	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	

}
