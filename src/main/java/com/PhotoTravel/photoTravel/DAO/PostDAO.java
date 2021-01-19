package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Post;

@Repository
public interface PostDAO extends JpaRepository<Post,Long> {

}
