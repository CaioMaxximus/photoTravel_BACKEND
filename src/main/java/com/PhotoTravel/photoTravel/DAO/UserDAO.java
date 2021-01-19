package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

}
