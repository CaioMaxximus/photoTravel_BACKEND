package com.PhotoTravel.photoTravel.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PhotoTravel.photoTravel.model.Post;
import java.util.List;
import com.PhotoTravel.photoTravel.model.User;

@Repository
public interface PostDAO extends JpaRepository<Post,Long> {

    public List<Post> findByOwnerUser(User user);
    
    @Query(value = "select distinct on (id)id ,creation_date , image_url , owner_user_nickname, num_likes "
    		+ "from post p inner join post_tags t on p.id = t.post_id \r\n" + 
    		"where tags_id ~ :tags", nativeQuery = true)
    public List<Post> findPostsByTags(@Param("tags") String tags);
}
