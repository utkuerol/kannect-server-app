package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import java.util.List;

/**
 * Advanced repository interface which includes find methods related to message entity.
 */
public interface MessageRepositoryAdvanced {
    
    /**
     * Find all received messages from the database sorted by date.
     *
     * @param receiver receiver of searched messages
     * @return list of all messages received sorted by date
     */
    List<Message> findAllReceivedMessagesSortedByDate(User receiver);
    
    /**
     * Find all sent messages from the database sorted by date.
     * @param sender sender of searched messages
     * @return list of all messages sent sorted by date
     */
    List<Message> findAllSentMessagesSortedByDate(User sender);
}
