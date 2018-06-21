package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;

import java.util.Date;
import java.util.List;

/**
 * The Interface EventRepositoryAdvanced.
 */
public interface EventRepositoryAdvanced{
    
    /**
     * Find all events by date.
     *
     * @param date date of searched events
     * @return events with the specified date
     */
    List<Event> findAllByDate(Date date);

    /**
     * Find all events containing the string word sorted by date.
     *
     * @param word word to be searched in all events names
     * @return {@linkplain java.util.List> of all events containing the string word at the given date
     */
    List<Event> findByNameSortedByDate(String word);

    /**
     * Find all events containing the string word sorted by category.
     *
     * @param word word to be searched in all events names.
     * @param category category of searched events
     * @return {@linkplain java.util.List> of all events containing the string word with the specified category
     */
    List<Event> findAllByNameSortedByCategory(String word, Category category);


    /**
     * Find all events sorted by Date
     * @return {@linkplain java.util.List> of all events
     */
    List<Event> findAllSortedByDate();
}
