package com.pse.testserver.service;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepository;
import com.pse.testserver.repository.impl.EventRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRepositoryAdvancedImpl eventRepositoryADV;

    @Transactional
    public List<Event> getAllByName(String name) {
        return eventRepositoryADV.findAllByName(name);
    }

    @Transactional
    public List<Event> getAllByDate(Date date) {
        return eventRepositoryADV.findAllByDate(date);
    }

    @Transactional
    public List<Event> getByNmeSortedByDate(String name, Date date) {
        return eventRepositoryADV.findByNmeSortedByDate(name, date);
    }

    @Transactional
    public List<User> getParticipatedUsers(Event event) {
        return eventRepositoryADV.findParticipatedUsers(event);
    }


    @Transactional
    public List<Event> getAllSortedByDate(String name, Date date) {
        return eventRepositoryADV.findAllSortedByDate(name, date);
    }


    @Transactional
    public List<Event> getAllByNameSortedByCategory(String name, Category category) {
        return eventRepositoryADV.findAllByNameSortedByCategory(name, category);
    }

    @Transactional
    public Event getById(int id) {
        return eventRepository.findById(id);
    }

    @Transactional
    public Event getByName(String name) {
        return eventRepository.findByName(name);
    }

    @Transactional
    public Event getByDate(Date date) {
        return eventRepository.findByDate(date);
    }

    @Transactional
    public boolean participateInEvent(Event event) {
        return false;
    }

    @Transactional
    public boolean createEvent(Event event) {
        return false;
    }

    @Transactional
    public boolean deleteEvent(Event event) {
        return false;
    }

    @Transactional
    public boolean editEvent(Event editedEvent, Event eventToEdit) {
        return false;
    }
}
