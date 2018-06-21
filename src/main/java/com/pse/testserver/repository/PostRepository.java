package com.pse.testserver.repository;

import com.pse.testserver.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Simple interface which includes find methods related to post entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface PostRepository extends CrudRepository<Post,String> {


    /**
     * Find all.
     *
     * @return a list of all available posts
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
