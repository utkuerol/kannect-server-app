package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import java.util.Set;


import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryAdvanced{
    
    Set<User> findAllByName(String name);
}
