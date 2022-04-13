package com.PhotoTravel.photoTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
@SpringBootApplication
@EnableWebMvc
public class PhotoTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoTravelApplication.class, args);
	}
	
}
