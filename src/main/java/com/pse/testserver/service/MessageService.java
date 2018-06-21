package com.pse.testserver.service;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.MessageRepository;
import com.pse.testserver.repository.impl.MessageRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the message entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly message objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class MessageService {

    /**
     * Injected MessageRepository class dependency.
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Injected MessageRepositoryAdvancedImpl class dependency.
     */
    @Autowired
    private MessageRepositoryAdvancedImpl messageRepositoryADV;

    /**
     * Finds a message by its unique id.
     *
     * @param id to search for.
     * @return found message.
     */
    @Transactional
    public Message getById(int id) {
        return messageRepository.findById(id);
    }

    /**
     * Gets list of messages, which are received by the given user.
     * @param receiver of the messages.
     * @return list of messages.
     */
    @Transactional
    public List<Message> getAllByReceiverSortedByDate(User receiver) {
        return messageRepositoryADV.findAllByReceiverSortedByDate(receiver);
    }

    /**
     * Gets list of messages, which are sent by the given user.
     * @param sender of the messages.
     * @return list of messages.
     */
    @Transactional
    public List<Message> findAllBySenderSortedByDate(User sender) {
        return messageRepositoryADV.findAllBySenderSortedByDate(sender);
    }

    /**
     * Saves a new message object into the system.
     * @param message to be saved, received from the client.
     */
    @Transactional
    public void sendMessage(Message message) {

    }
}
