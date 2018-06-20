package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById(long id);
    Event findByName(String name);
    Event findByDate(Date date);
}
