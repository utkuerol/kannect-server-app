package com.pse.testserver.repository;

import com.pse.testserver.entities.User;

import java.util.List;


/**
 * Advanced repository interface which includes find methods related to user entity.
 *
 */
public interface UserRepositoryAdvanced {
    
    /**
     * Find all users by name.
     *
     * @param name the name of user
     * @return list of all users having the specified name
     */
    List<User> findAllByName(String name);
}
