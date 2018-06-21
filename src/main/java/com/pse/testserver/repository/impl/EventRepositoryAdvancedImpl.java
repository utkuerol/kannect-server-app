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

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllByDate(java.util.Date)
     */
    @Override
    public List<Event> findAllByDate(Date date) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findByNameSortedByDate(java.lang.String)
     */
    @Override
    public List<Event> findByNameSortedByDate(String name) {
        return null;
    }


    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllSortedByDate(java.lang.String)
     */
    public List<Event> findAllSortedByDate() {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllByNameSortedByCategory(java.lang.String, com.pse.testserver.entities.Category)
     */
    public List<Event> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }

    /**
     * @see com.pse.testserver.repository.EventRepositoryAdvanced#findAllByDate(java.lang.String)
     */
    public List<Event> findAllByName(String name) {
        return null;
    }
}
