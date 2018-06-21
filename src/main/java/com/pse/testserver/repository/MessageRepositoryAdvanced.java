package com.pse.testserver.repository;

import java.util.List;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageRepositoryAdvanced.
 */
public interface MessageRepositoryAdvanced {
    
    /**
     * find all received messages sorted by date.
     *
     * @param receiver receiver of searched messages
     * @return {@linkplain java.util.List> of all messages received sorted by date
     */
    List<Message> findAllByReceiverSortedByDate(User receiver);

    /**
     * find all received messages sorted by sender.
     *
     * @param sender sender of searched messages
     * @return {@linkplain java.util.List> of all messages received sorted by sender
     */
    List<Message> findAllByReceiverSortedBySender(User sender);
}
