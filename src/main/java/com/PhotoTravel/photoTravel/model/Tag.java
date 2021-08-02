package com.PhotoTravel.photoTravel.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Tag {

	@Id
	private String id;
}
