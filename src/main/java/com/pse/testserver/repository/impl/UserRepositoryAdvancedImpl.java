package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepositoryAdvanced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;
    

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }
    
}
