package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * Simple repository interface which includes find methods related to user entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
    /**
     * Find user by id.
     *
     * @param id unique id of the searched user
     * @return user with the defined id
     */
    User findById(long id);
    
    /**
     * Find by name.
     *
     * @param name name of the searched User
     * @return list of all Users with the same given name
     */
    List<User> findByName(String name);

}
