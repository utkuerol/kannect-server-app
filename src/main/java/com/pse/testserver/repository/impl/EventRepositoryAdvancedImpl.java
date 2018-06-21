package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepositoryAdvanced;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * The Class EventRepositoryAdvancedImpl.
 */
@Repository
public class EventRepositoryAdvancedImpl implements EventRepositoryAdvanced {

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllByDate(java.util.Date)
     */
    @Override
    public List<Event> findAllByDate(Date date) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findByNmeSortedByDate(java.lang.String)
     */
    @Override
    public List<Event> findByNameSortedByDate(String word) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findParticipatedUsers(com.pse.testserver.entities.Event)
     */
    @Override
    public List<User> findParticipatedUsers(Event event) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllSortedByDate(java.lang.String, java.util.Date)
     */
    public List<Event> findAllSortedByDate(String word) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllByNameSortedByCategory(java.lang.String, com.pse.testserver.entities.Category)
     */
    public List<Event> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }

}
