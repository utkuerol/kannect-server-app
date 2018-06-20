package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepositoryAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

}
