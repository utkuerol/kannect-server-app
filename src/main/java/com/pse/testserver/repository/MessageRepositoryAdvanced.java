package com.pse.testserver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.plugin2.message.Message;

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
    @Query(value = "SELECT * from messages m where m.receiver_id like receiver_id ORDER BY date DESC",
            nativeQuery = true)
    List<Message> findAllReceivedMessagesSortedByDate(@Param("receiver_id") long receiver);
    
    /**
     * Find all sent messages from the database sorted by date.
     * @param sender sender of searched messages
     * @return list of all messages sent sorted by date
     */
    @Query(value = "SELECT * from messages m where m.sender_id like sender_id ORDER BY date DESC",
            nativeQuery = true)
    List<Message> findAllSentMessagesSortedByDate(@Param("sender_id") long sender);
}