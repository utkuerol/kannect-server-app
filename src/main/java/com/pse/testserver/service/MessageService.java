package com.pse.testserver.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pse.testserver.entities.User;
import com.pse.testserver.repository.impl.MessageRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageRepositoryAdvancedImpl messageRepositoryADV;

    @Transactional
    public Message getById(int id) {
        return messageRepository.findById(id);
    }


    @Transactional
    Message getBySender(User user) {
        return messageRepository.findBySender(user);
    }


    @Transactional
    public Message getByReceiver(User user) {
        return messageRepository.findByReceiver(user);
    }


    @Transactional
    public List<Message> getAllByReceiverSortedByDate(User user, Date date) {
        return messageRepositoryADV.findAllByReceiverSortedByDate(user, date);
    }

    @Transactional
    public List<Message> findAllByReceiverSortedBySender(User user, Date date) {
        return messageRepositoryADV.findAllByReceiverSortedBySender(user, date);
    }
}
