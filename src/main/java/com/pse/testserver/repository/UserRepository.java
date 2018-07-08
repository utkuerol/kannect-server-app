package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


/**
 * Simple repository interface which includes find methods related to user entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
    /**
     * Find user from the database by id.
     *
     * @param id unique id of the searched user
     * @return user with the defined id
     */
    @Query(value = "SELECT * from users u where u.id like id",
            nativeQuery = true)
    User findById(@Param("id") long id);
    
    /**
     * Find users from the database by name.
     *
     * @param name name of the searched User
     * @return list of all Users with the same given name
     */
    @Query(value = "SELECT * from users u where u.name like name",
            nativeQuery = true)
    List<User> findByName(@Param("name") String name);

}
