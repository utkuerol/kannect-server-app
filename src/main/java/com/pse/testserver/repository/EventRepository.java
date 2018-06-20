package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById(int id);
    Event findByName(String name);
    Event findByDate(String date);
}
