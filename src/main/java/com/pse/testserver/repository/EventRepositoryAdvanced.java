package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.User;

import java.util.Date;
import java.util.List;

public interface EventRepositoryAdvanced{
    
    List<Event> findAllByDate(Date date);
    List<Event> findByNmeSortedByDate(String name, Date date);
    List<Event> findAllByNameSortedByCategory(String name, Category category);
    List<User> findParticipatedUsers(Event event);
}
