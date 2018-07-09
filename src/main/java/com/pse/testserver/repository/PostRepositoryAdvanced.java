package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Advanced repository interface which includes find methods related to post entity.
 *
 */
public interface PostRepositoryAdvanced {

    /**
     * Find all posts of a user from the database.
     *
     * @param id id of the user
     * @return list of all posts of the given user
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY like id",
            nativeQuery = true)
    List<Post> findAllOwnedByUser(@Param("id") long id);

    /**
     * find all posts of a group from the database.
     *
     * @param id the id of the group
     * @return list of all posts of the given group
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY like id",
            nativeQuery = true)
    List<Post> findAllByGroup(@Param("id") long id);

    /**
     * Find all posts of an event from the database.
     *
     * @param id the id of the event
     * @return list of all posts of the given event
     */
    @Query(value = "SELECT * from posts p where p.OWNED_BY like id",
            nativeQuery = true)
    List<Post> findAllByEvent(@Param("id") long id);

}
