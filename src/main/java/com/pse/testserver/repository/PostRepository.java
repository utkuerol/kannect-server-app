package com.pse.testserver.repository;

import com.pse.testserver.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Simple interface which includes find methods related to post entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface PostRepository extends CrudRepository<Post,Integer> {


    /**
     * Find all posts from the database.
     *
     * @return a list of all available posts
     */

    List<Post> findAll();

    /**
     * Find post from the database by id.
     *
     * @param id unique id of the searched post
     * @return post with the defined id
     */
    Post findById(long id);

    /**
     * Find all posts of a user from the database.
     *
     * @param id id of the user
     * @return list of all posts of the given user
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY = :id",
            nativeQuery = true)
    List<Post> findAllOwnedByUser(@Param("id") long id);

    /**
     * find all posts of a group from the database.
     *
     * @param id the id of the group
     * @return list of all posts of the given group
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY = :id",
            nativeQuery = true)
    List<Post> findAllByGroup(@Param("id") long id);

    /**
     * Find all posts of an event from the database.
     *
     * @param id the id of the event
     * @return list of all posts of the given event
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY = :id",
            nativeQuery = true)
    List<Post> findAllByEvent(@Param("id") long id);
}
