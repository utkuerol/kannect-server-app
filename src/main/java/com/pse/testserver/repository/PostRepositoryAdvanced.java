package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;

import java.util.List;


/**
 * Advanced repository interface which includes find methods related to post entity.
 *
 */
public interface PostRepositoryAdvanced {

    /**
     * Find all posts of a user.
     *
     * @param user user
     * @return list of all posts of the given user
     */
    List<Post> findAllByUser(User user);

    /**
     * find all posts of a group.
     *
     * @param group group
     * @return list of all posts of the given group
     */
    List<Post> findAllByGroup(Group group);

    /**
     * Find all posts of an event.
     *
     * @param event the event
     * @return list of all posts of the given event
     */
    List<Post> findAllByEvent(Event event);

}
