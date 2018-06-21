package com.pse.testserver.repository;

import com.pse.testserver.entities.User;

import java.util.List;


/**
 * The Interface UserRepositoryAdvanced.
 */
public interface UserRepositoryAdvanced {
    
    /**
     * Find all users by name.
     *
     * @param name the name of user
     * @return {@linkplain java.util.List> of all users having the specified name
     */
    List<User> findAllByName(String name);
}
