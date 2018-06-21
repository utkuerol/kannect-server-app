package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * The Interface UserRepository.
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
    
    /**
     * Find by email.
     *
     * @param email address of user
     * @return user with the specified address mail
     */
    User findByEmail(String email);

}
