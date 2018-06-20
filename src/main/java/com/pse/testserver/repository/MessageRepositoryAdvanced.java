package com.pse.testserver.repository;

import java.util.Date;
import java.util.List;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

public interface MessageRepositoryAdvanced {
    List<Message> findAllByReceiverSortedByDate(User user, Date date);

    List<Message> findAllByReceiverSortedBySender(User user, Date date);
}
