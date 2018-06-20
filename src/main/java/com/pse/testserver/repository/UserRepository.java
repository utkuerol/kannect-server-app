package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
    User findById(long id);
    User findByName(String name);
    User findByEmail(String email);
    
/*
    @Modifying 
    @Query("update User set Email = :email where id = :id")
    int updateUser(int id, String email);
    */

}
