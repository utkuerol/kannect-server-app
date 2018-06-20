package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepository;

public class UserService {
	@Autowired
    UserRepository userRepository;

    @Transactional
    public List<User> getAllPosts() {
        return userRepository.findAll();
    }
}
