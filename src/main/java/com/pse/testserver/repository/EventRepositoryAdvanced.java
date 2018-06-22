package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import java.util.Date;
import java.util.List;

/**
 * Advanced repository interface which includes find methods related to event entity.
 *
 */
public interface EventRepositoryAdvanced{
    
    /**
     * Find all events from the database by date.
     *
     * @param date date of searched events
     * @return events with the specified date
     */
    List<Event> findAllByDate(Date date);

    /**
     * Find all events from the database containing the string name sorted by date.
     *
     * @param name word to be searched in all events names
     * @return list of all events containing the string name at the given date
     */
    List<Event> findByNameSortedByDate(String name);

    /**
     * Find all events from the database containing the string name sorted by category.
     *
     * @param name word to be searched in all events names.
     * @param category category of searched events
     * @return list of all events containing the string name with the specified category
     */
    List<Event> findAllByNameSortedByCategory(String name, Category category);


    /**
     * Find all events from the database sorted by Date
     * @param name word to be searched in all events names.
     * @return list of events, chronologically sorted with the latest event being the first element.
     */
    List<Event> findAllSortedByDate();
}
