package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Post;
import java.util.List;
import com.PhotoTravel.photoTravel.model.User;

@Repository
public interface PostDAO extends JpaRepository<Post,Long> {

    public List<Post> findByOwnerUser(User user);
}
