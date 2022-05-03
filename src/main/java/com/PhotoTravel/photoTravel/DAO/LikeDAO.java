package com.PhotoTravel.photoTravel.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Like;
import com.PhotoTravel.photoTravel.model.Post;

@Repository
public interface LikeDAO extends JpaRepository<Like,Long>{

	@Query("select l from post_like l where l.post = :post and l.ownerNick like :ownerNick ")
	public Like findByPostAndOwnerNick(@Param("post")Post post, @Param("ownerNick") String ownerNick);
}
