package com.pse.testserver.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,String> {

    @Query(value = "SELECT * from post",
            nativeQuery=true)
    List<Post> findAll();
}
