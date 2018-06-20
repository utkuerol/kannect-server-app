package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepositoryAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public class EventRepositoryAdvancedImpl implements EventRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Event> findAllByDate(Date date) {
        return null;
    }

    @Override
    public List<Event> findByNmeSortedByDate(String name, Date date) {
        return null;
    }

    @Override
    public List<User> findParticipatedUsers(Event event) {
        return null;
    }

    public List<Event> findAllSortedByDate(String name, Date date) {
        return null;
    }

    public List<Event> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }

    public List<Event> findAllByName(String name) {
        return null;
    }
}
