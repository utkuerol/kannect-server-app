package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    
    /**
     * 
     * @param id unique id of the searched event
     * @return event with the defined id
     */
    Event findById(int id);
    
    /**
     * 
     * @param name name of the searched event
     * @return event with the defined name
     */
    Event findByName(String name);
    
    /**
     * 
     * @param date date of the searched event
     * @return event with the defined date
     */
    Event findByDate(Date date);
}
