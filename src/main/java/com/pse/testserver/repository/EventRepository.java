package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

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
    Event findById(int id);

    /**
     * Find all events from the database by date.
     *
     * @param date date of searched events
     * @return events with the specified date
     */
    @Query(value = "Select * from events e where e.date like :date", nativeQuery = true)
    List<Event> findAllByDate(@Param("date") Date date);

    /**
     * Find all events from the database containing the string name sorted by date.
     *
     * @param name word to be searched in all events names
     * @return list of all events containing the string name at the given date
     */
    @Query(value = "Select * from events e where e.name like %:name% ORDER BY date DESC", nativeQuery = true)
    List<Event> findByNameSortedByDate(@Param("name") String name);

    /**
     * Find all events from the database containing the string name sorted by category.
     *
     * @param name     word to be searched in all events names.
     * @param category category of searched events
     * @return list of all events containing the string name with the specified category
     */
    @Query(value = "Select * from events e where e.name like %:name% and e.category_id like :category", nativeQuery = true)
    List<Event> findAllByNameSortedByCategory(@Param("name") String name, @Param("category") long category);


    /**
     * Find all events from the database sorted by Date
     *
     * @return list of events, chronologically sorted with the latest event being the first element.
     */
    @Query(value = "Select * from events ORDER BY date DESC", nativeQuery = true)
    List<Event> findAllSortedByDate();

}
