package com.pse.testserver.repository;

import com.pse.testserver.entities.User;

import java.util.List;

public interface UserRepositoryAdvanced {
    
    List<User> findAllByName(String name);
}
