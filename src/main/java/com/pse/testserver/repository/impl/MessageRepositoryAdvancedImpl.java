package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.MessageRepositoryAdvanced;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class MessageRepositoryAdvancedImpl implement the find methods related to event entity, which are not
 * supported by the spring framework.
 */
@Repository
public class MessageRepositoryAdvancedImpl implements MessageRepositoryAdvanced {


    /**
     * @see com.pse.testserver.repository.MessageRepositoryAdvanced#findAllByReceiverSortedByDate(com.pse.testserver.entities.User)
     */
    public List<Message> findAllReceivedMessagesSortedByDate(User receiver) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.MessageRepositoryAdvanced#findAllByReceiverSortedByDate(com.pse.testserver.entities.User)
     */
    public List<Message> findAllSentMessagesSortedByDate(User sender) {
        return null;
    }
}
