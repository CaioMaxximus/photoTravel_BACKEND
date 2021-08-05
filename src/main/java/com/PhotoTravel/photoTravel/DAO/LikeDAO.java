package com.PhotoTravel.photoTravel.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.model.Post;

@Repository
public interface LikeDAO extends JpaRepository<Like,Long>{

	
	public Optional<Like> findByPostAndOwnerNick(Post post, String ownerNick);
}
