package com.PhotoTravel.photoTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.UserDAO;
import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.model.UserDTO;;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;

	public UserDTO addUser(User newUser) {

		User userDB = userDao.findById(newUser.getNickName()).get();
		if (userDB != null) {
			userDao.save(newUser);
			return new UserDTO(newUser);
		} else {

			return null;
		}

	}

	public User addUser_(User newUser) {

		User userDB = userDao.findById(newUser.getNickName()).get();
		if (userDB != null) {
			userDao.save(newUser);
			return newUser;
		} else {

			return null;
		}

	}

	public User getUser() {
		return new User("", "");
	}

}
