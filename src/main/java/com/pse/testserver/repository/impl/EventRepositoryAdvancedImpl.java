package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepositoryAdvanced;
import com.pse.testserver.repository.UserRepositoryAdvanced;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public class EventRepositoryAdvancedImpl implements EventRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Set<Event> findAllByDate(Date date) {
        return null;
    }
    
    @Override
    public Set<Event> findByNmeSortedByDate(String name, Date date) {
        return null;
    }
    
    @Override
    public Set<User> findParticipatedUsers(Event event) {
        return null;
    }
    
    public Set<Event> findAllSortedByDate(String name, Date date) {
        return null;
    }
    
    public Set<Event> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }
}
