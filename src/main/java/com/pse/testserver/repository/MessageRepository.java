package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import org.springframework.data.repository.CrudRepository;

/*

 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    
    /**
     * find message by id
     * @param id unique id of the searched message
     * @return message with the defined id
     */
    Message findById(int id);

    /**
     * find message by sender
     * @param sender message sender
     * @return message sended by the sender
     */
    Message findBySender(User sender);

    /**
     * find message by receiver
     * @param receiver message receiver
     * @return message received by the receiver
     */
    Message findByReceiver(User receiver);
}
