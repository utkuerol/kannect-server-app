package com.pse.testserver.service;

import java.util.List;

import com.pse.testserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.MessageRepository;

public class MessageService {
	@Autowired
    MessageRepository messageRepository;

    @Transactional
    public Message getById(int id) {
        return messageRepository.findById(id);
    }

    @Transactional
    Message getBySender(User user) {
        return messageRepository.findBySender(user);
    }

    public Message getByReceiver(User user) {
        return messageRepository.findByReceiver(user);
    }
}
