package com.pse.testserver.service;

import java.util.List;

import com.pse.testserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.repository.impl.UserRepositoryAdvancedImpl;

import javax.jws.soap.SOAPBinding;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    UserRepositoryAdvancedImpl userRepositoryADV;

    @Transactional
    public List<User> getAllByName(String name) {
        return userRepositoryADV.findAllByName(name);
    }

    @Transactional
    public User getById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public boolean subscribeUser(User subscriber, User subscribed) {
        return false;
    }

    @Transactional
    public boolean unsubscribeUser(User subscriber, User subscribed) {
        return false;
    }


}
