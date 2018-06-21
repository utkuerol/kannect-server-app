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

/**
 * Service class implementing the business logic regarding the event entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly event objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class EventService {

    /**
     * Injected EventRepository class dependency.
     */
    @Autowired
    private EventRepository eventRepository;

    /**
     * Injected EventRepositoryAdvancedImpl class dependency.
     */
    @Autowired
    private EventRepositoryAdvancedImpl eventRepositoryADV;

    /**
     * Method to look for events, which include the given String in their names.
     *
     * @param name to look for events.
     * @return list of wanted events.
     */
    @Transactional
    public List<Event> getAllByName(String name) {
        return eventRepositoryADV.findAllByName(name);
    }

    /**
     * Method to look for events, which take place on the given date
     * @param date to look for events.
     * @return list of wanted events.
     */
    @Transactional
    public List<Event> getAllByDate(Date date) {
        return eventRepositoryADV.findAllByDate(date);
    }

    /**
     * Method to look for events, which include the given String in their names.
     * @param name to look for events.
     * @return list of wanted events chronologically sorted with the latest event being the first element.
     */
    @Transactional
    public List<Event> getByNameSortedByDate(String name) {
        return eventRepositoryADV.findByNameSortedByDate(name);
    }

    @Transactional
    public List<User> getParticipatedUsers(Event event) {
        //event.getUsers etc....
        return null;
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
