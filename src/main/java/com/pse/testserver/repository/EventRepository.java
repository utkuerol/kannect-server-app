package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

/**
 * The Interface EventRepository.
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    
    /**
     * Find event by id.
     *
     * @param id unique id of the searched event
     * @return event with the defined id
     */
    Event findById(int id);
    
    /**
     * Fiind event by name.
     *
     * @param name name of the searched event
     * @return event with the defined name
     */
    Event findByName(String name);
    
    /**
     * Find event by date.
     *
     * @param date date of the searched event
     * @return event with the specified date
     */
    Event findByDate(Date date);
}
