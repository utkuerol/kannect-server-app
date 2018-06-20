package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;

import java.util.Date;
import java.util.Set;


import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositoryAdvanced{
    
    Set<Event> findAllByDate(Date date);
    Set<Event> findByNmeSortedByDate(String name, Date date);
    Set<Event> findAllByNameSortedByCategory(String name, Category category);
    Set<User> findParticipatedUsers(Event event);
}
