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
     * Looks for events, which include the given String in their names.
     *
     * @param name to look for events.
     * @return list of wanted events.
     */
    @Transactional
    public List<Event> getAllByName(String name) {
        return eventRepositoryADV.findAllByName(name);
    }

    /**
     * Looks for events, which take place on the given date
     * @param date to look for events.
     * @return list of wanted events.
     */
    @Transactional
    public List<Event> getAllByDate(Date date) {
        return eventRepositoryADV.findAllByDate(date);
    }

    /**
     * Looks for events, which include the given String in their names.
     * @param name to look for events.
     * @return list of wanted events chronologically sorted with the latest event being the first element.
     */
    @Transactional
    public List<Event> getByNameSortedByDate(String name) {
        return eventRepositoryADV.findByNameSortedByDate(name);
    }

    /**
     * Looks for users, which participate in the given event.
     *
     * @param event .
     * @return list of users, which participate in the given event.
     */
    @Transactional
    public List<User> getParticipatedUsers(Event event) {
        //event.getUsers etc....
        return null;
    }

    /**
     * Gets all events
     * @return list of events, chronologically sorted with the latest event being the first element.
     */
    @Transactional
    public List<Event> getAllSortedByDate() {
        return eventRepositoryADV.findAllSortedByDate();
    }

    /**
     * Looks for events, which include the given String in their names and fall into the given
     * category.
     * @param name to look for.
     * @param category under which the search will be performed.
     * @return list of wanted events.
     */
    @Transactional
    public List<Event> getAllByNameSortedByCategory(String name, Category category) {
        return eventRepositoryADV.findAllByNameSortedByCategory(name, category);
    }

    /**
     * Gets the event by the given id.
     * @param id to look for.
     * @return event with the given id.
     */
    @Transactional
    public Event getById(long id) {
        return eventRepository.findById(id);
    }

    /**
     * Saves an event to the system.
     * @param event to be saved.
     */
    @Transactional
    public void createEvent(Event event) {
    }

    /**
     * Deletes an event from the system.
     * @param event to be deleted.
     */
    @Transactional
    public void deleteEvent(Event event) {
    }

    /**
     * Edits an event by saving the editedEvent received from the client.
     * @param editedEvent received from the client, has the edited attributes.
     */
    @Transactional
    public void editEvent(Event editedEvent) {

    }
}
