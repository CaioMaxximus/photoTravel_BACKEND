package com.PhotoTravel.photoTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendTextEmail(String content, String subject  ,String emailDestiny) {
	
		
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject(subject);
			mailMessage.setText(content);
			mailMessage.setTo(emailDestiny);
			
			emailSender.send(mailMessage);
	}
	
}
