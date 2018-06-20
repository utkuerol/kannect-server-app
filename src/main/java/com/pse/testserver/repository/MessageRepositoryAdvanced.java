package com.pse.testserver.repository;

import java.util.Date;
import java.util.Set;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

public interface MessageRepositoryAdvanced {
    Set<Message> findAllByReceiverSortedByDate(User user, Date date);
    Set<Message> findAllByReceiverSortedBySender(User user, Date date);
}
