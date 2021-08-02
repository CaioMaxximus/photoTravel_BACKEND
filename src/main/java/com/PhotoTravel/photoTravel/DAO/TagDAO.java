package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Tag;

@Repository
public interface TagDAO extends JpaRepository<Tag ,String>{

}
