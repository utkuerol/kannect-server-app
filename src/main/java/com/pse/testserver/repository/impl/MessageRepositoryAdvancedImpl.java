package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.MessageRepositoryAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MessageRepositoryAdvancedImpl implements MessageRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;

    public List<Message> findAllByReceiverSortedByDate(User user) {
        return null;
    }

    public List<Message> findAllByReceiverSortedBySender(User user) {
        return null;
    }
}
