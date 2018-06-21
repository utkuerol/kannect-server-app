package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.MessageRepositoryAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageRepositoryAdvancedImpl.
 */
@Repository
public class MessageRepositoryAdvancedImpl implements MessageRepositoryAdvanced {

    /** The entity manager. */
    @Autowired
    private EntityManager entityManager;

    /* (non-Javadoc)
     * @see com.pse.testserver.repository.MessageRepositoryAdvanced#findAllByReceiverSortedByDate(com.pse.testserver.entities.User)
     */
    public List<Message> findAllByReceiverSortedByDate(User user) {
        return null;
    }

    /* (non-Javadoc)
     * @see com.pse.testserver.repository.MessageRepositoryAdvanced#findAllByReceiverSortedBySender(com.pse.testserver.entities.User)
     */
    public List<Message> findAllByReceiverSortedBySender(User user) {
        return null;
    }
}
