package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import java.util.List;

/**
 * The Interface MessageRepositoryAdvanced.
 */
public interface MessageRepositoryAdvanced {
    
    /**
     * Find all received messages sorted by date.
     *
     * @param receiver receiver of searched messages
     * @return list of all messages received sorted by date
     */
    List<Message> findAllByReceiverSortedByDate(User receiver);


    List<Message> findAllBySenderSortedByDate(User sender);
}
