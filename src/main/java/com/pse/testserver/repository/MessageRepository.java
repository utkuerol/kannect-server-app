package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    Message findById(int id);
    Message findBySender(User user);
    Message findByReceiver(User user);
}
