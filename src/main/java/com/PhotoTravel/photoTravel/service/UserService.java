package com.PhotoTravel.photoTravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.UserDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.model.UserDTO;;

@Service
public class UserService {

	private final UserDAO userDao;

	@Autowired
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public UserDTO addUser(User newUser) {

		findUserAlreadyExists(newUser.getNickname());
		User user = new User(newUser.getNickname(), newUser.getEmail(), newUser.getPassword());
		userDao.save(user);
		return new UserDTO(user);
	}

	/// Produca
	public User addUser_(User newUser) {

		findUserAlreadyExists(newUser.getNickname());
		User user = new User(newUser.getNickname(), newUser.getEmail(), newUser.getPassword());
		return user;

	}
	
	

	public UserDTO getUserByNickDTO(String nick) {
		findUserExists(nick);
		User user = userDao.findById(nick).get();
		return new UserDTO(user);

	}

	User getUserByNick(String nick) {
		findUserExists(nick);
		User user = userDao.findById(nick).get();
		return user;

	}
	public List<User> getAllUsers() {

		return userDao.findAll();
	}

	public void findUserAlreadyExists(String nick) {
		if (userDao.findById(nick).isPresent()) {
			throw new ResourceAlreadyExistsException("User nick already exists");
		}

	}

	public void findUserExists(String nick) {
		if (!userDao.findById(nick).isPresent()) {
			throw new ResourceNotFoundException("User nick dont exists");
		}

	}
}
