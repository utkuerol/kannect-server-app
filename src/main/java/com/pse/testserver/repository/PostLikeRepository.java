package com.pse.testserver.repository;

import com.pse.testserver.entities.PostLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PostLikeRepository extends CrudRepository<PostLike, Integer> {

    @Query(value = "Select * from post_likes pl where pl.user_id = :userId and pl.post_id = :postId", nativeQuery = true)
    PostLike findByUserAndPostId(@Param("userId") int userId, @Param("postId") int postId);
}
