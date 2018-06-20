package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.MessageRepository;

public class MessageService {
	@Autowired
    MessageRepository messageRepository;

    @Transactional
    public List<Post> getAllPosts() {
        return messageRepository.findAll();
    }
}
