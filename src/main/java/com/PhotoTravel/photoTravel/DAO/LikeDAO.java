package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Like;

@Repository
public interface LikeDAO extends JpaRepository<Like,Long>{

}
