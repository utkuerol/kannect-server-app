package com.pse.testserver.service;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepository;
import com.pse.testserver.repository.impl.UserRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
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

    @Transactional
    public boolean joinGroup(User user, Group group) {
        return false;
    }

    @Transactional
    public boolean leaveGroup(User user, Group group) {
        return false;
    }

    @Transactional
    public boolean participateInEvent(User user, Event event) {
        return false;
    }

    @Transactional
    public boolean leaveEvent(User user, Event event) {
        return false;
    }
}
