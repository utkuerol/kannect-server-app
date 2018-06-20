package com.pse.testserver.service;

import java.util.List;

import com.pse.testserver.repository.impl.UserRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepository;

public class UserService {
    @Autowired
    UserRepositoryAdvancedImpl userRepositoryADV;
    UserRepository userRepository;


    @Transactional
    public List<User> getAllByName(User user) {
        return userRepositoryADV.findAllByName(user.getName());
    }

    @Transactional
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public User getById(User user) {
        return userRepository.findById(user.getId());
    }

    @Transactional
    public User geByMail(User user) {
        return  userRepository.findByEmail(user.getEmail());
    }
}
