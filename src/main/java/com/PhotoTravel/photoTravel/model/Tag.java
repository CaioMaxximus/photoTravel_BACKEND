package com.PhotoTravel.photoTravel.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	private String id;
	
	public Tag(String tag) {
		this.id = tag;
		
	}
	public Tag() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
