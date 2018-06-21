package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

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
    Event findById(long id);
    
    /**
     * Find event by name.
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
