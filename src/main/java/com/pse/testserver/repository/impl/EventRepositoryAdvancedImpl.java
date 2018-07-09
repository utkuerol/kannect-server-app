package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.repository.EventRepositoryAdvanced;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * The Class EventRepositoryAdvancedImpl implement the find methods related to event entity, which are not
 * supported by the spring framework.
 */
@Repository
public class EventRepositoryAdvancedImpl implements EventRepositoryAdvanced {


    @Override
    public List<Event> findAllByDate(Date date) {
        return null;
    }


    @Override
    public List<Event> findByNameSortedByDate(String name) {
        return null;
    }

    @Override
    public List<Event> findAllByNameSortedByCategory(String name, long category) {
        return null;
    }



    public List<Event> findAllSortedByDate() {
        return null;
    }


    public List<Event> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }


    public List<Event> findAllByName(String name) {
        return null;
    }
}
