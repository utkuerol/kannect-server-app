package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;

import java.util.Date;
import java.util.List;

public interface EventRepositoryAdvanced{
    
    List<Event> findAllByDate(Date date);

    List<Event> findByNameSortedByDate(String name);
    List<Event> findAllByNameSortedByCategory(String name, Category category);
}
