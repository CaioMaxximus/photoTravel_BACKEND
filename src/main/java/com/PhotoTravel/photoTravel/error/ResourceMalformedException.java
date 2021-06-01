package com.PhotoTravel.photoTravel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceMalformedException extends RuntimeException{
	
	public ResourceMalformedException(String message) {
		super(message);
	}

}
