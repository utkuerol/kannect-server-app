package com.pse.testserver.repository;

import com.pse.testserver.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,String> {


    /**
     * @return a {@linkplain java.util.List> of all available posts
     */
    List<Post> findAll();

    /**
     * find post by id
     * @param id unique id of the searched post
     * @return post with the defined id
     */
    Post findById(long id);
    

}
