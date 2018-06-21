package com.pse.testserver.repository;

import com.pse.testserver.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The Interface PostRepository.
 */
public interface PostRepository extends CrudRepository<Post,String> {


    /**
     * Find all.
     *
     * @return a {@linkplain java.util.List> of all available posts
     */
    List<Post> findAll();

    /**
     * Find post by id.
     *
     * @param id unique id of the searched post
     * @return post with the defined id
     */
    Post findById(long id);
    

}
