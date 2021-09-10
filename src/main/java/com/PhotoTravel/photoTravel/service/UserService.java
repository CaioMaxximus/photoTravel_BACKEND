package com.PhotoTravel.photoTravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhotoTravel.photoTravel.DAO.UserDAO;
import com.PhotoTravel.photoTravel.error.ResourceAlreadyExistsException;
import com.PhotoTravel.photoTravel.error.ResourceMalformedException;
import com.PhotoTravel.photoTravel.error.ResourceNotFoundException;
import com.PhotoTravel.photoTravel.model.User;
import com.PhotoTravel.photoTravel.model.UserDTO;;

@Service
public class UserService {

	@Autowired
	private final UserDAO userDao;

	
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	

	
	public UserDTO addUser(User newUser) {

		findUserAlreadyExists(newUser.getNickname(), newUser.getEmail());
		verifyUserData(newUser);
		User user = new User(newUser.getNickname(), newUser.getEmail(), newUser.getPassword() , newUser.getDescription());
		userDao.save(user);
		return new UserDTO(user);
	}

	
	private void verifyUserData(User newUser) {
		
		String passwordPattern = "(?=.*[}{^?=+-@])(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}";
		String nickNamePattern = "^[a-zA-Z0-9]{5,15}$";
		String emailPattern = "^\\S+@\\S+\\.\\S+$";
		
		if(newUser.getPassword() == null && !newUser.getPassword().matches(passwordPattern) &&
				newUser.getNickname() == null && !newUser.getNickname().matches(nickNamePattern) 
				&& newUser.getEmail() == null && !newUser.getEmail().matches(emailPattern) &&
				newUser.getDescription() == null && newUser.getDescription().length() > 10 &&
				newUser.getDescription().length() < 100){
			throw new ResourceMalformedException("Dados em formato incorreto."); 

		}
	}
	
	/// Producao
	public User addUser_(User newUser) {

		findUserAlreadyExists(newUser.getNickname(), newUser.getEmail());
		User user = new User(newUser.getNickname(), newUser.getEmail(), newUser.getPassword(), null);
		return user;

	}
	

	public UserDTO getUserByNickDTOShort(String nick) {
		findUserExists(nick);
		User user = userDao.findById(nick).get();
		return new UserDTO(user);

	}

	public UserDTO getUserByNickDTOLong(String nick) {
		findUserExists(nick);
		User user = userDao.findById(nick).get();
		return new UserDTO(user);

	}

	public User getUserByNick(String nick) {
		findUserExists(nick);
		User user = userDao.findById(nick).get();
		return user;

	}
	public List<User> getAllUsers() {

		return userDao.findAll();
	}

	public void findUserAlreadyExists(String nick, String email) {
		if (userDao.findById(nick).isPresent() || userDao.findByEmail(email) != null) {
			throw new ResourceAlreadyExistsException("User already exists");
		}

	}

	public void findUserExists(String nick) {
		System.out.println("nick in user: " + nick);
		if (!userDao.findById(nick).isPresent()) {
			throw new ResourceNotFoundException("User nick dont exists");
		}
	}
}
