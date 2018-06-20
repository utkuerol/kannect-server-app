package com.pse.testserver.repository;

import com.pse.testserver.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepositoryAdvanced {
    
    Set<User> findAllByName(String name);
}
