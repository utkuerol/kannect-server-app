package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Simple repository interface which includes find methods related to event entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    
    /**
     * Find event from database by id.
     *
     * @param id unique id of the searched event
     * @return event with the defined id
     */
    Event findById(long id);

}
