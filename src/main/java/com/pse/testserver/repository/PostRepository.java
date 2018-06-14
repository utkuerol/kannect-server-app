package com.pse.testserver.repository;

import com.pse.testserver.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,String> {

    @Query(value = "SELECT * from post",
            nativeQuery=true)
    List<Post> findAll();
}
