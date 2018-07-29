package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the Event entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class EventController {

    /**
     * Injected EventService class dependency.
     */
    @Autowired
    private EventService eventService;

    /**
     * Get requests with the "/events" suffix are mapped to this method.
     * Gets events, which include the given String in their names.
     *
     * @param name to look for events. When no parameter is given, the default value will be set to
     *             an empty String "". In this case a list of all events will be returned.
     * @return list of events.
     */
    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(value = "name", defaultValue = "") String name) {
        return eventService.getByNameSortedByDate(name);
    }

    /**
     * Post requests with the "/createEvent" suffix are mapped to this method.
     * Saves an event to the system.
     *
     * @param event to be saved.
     */
    @PostMapping("/createEvent")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    /**
     * Delete requests with the "/deleteEvent" suffix are mapped to this method.
     * Deletes an event from the system.
     *
     * @param eventId to be deleted.
     */
    @DeleteMapping("/deleteEvent")
    public void deleteEvent(@RequestParam(value = "eventId") int eventId) {
        eventService.deleteEvent(eventId);
    }

    /**
     * Post requests with the "/editEvent" suffix are mapped to this method.
     * Saves the edited event, received from the client.
     *
     * @param editedEvent to be saved.
     */
    @PostMapping("/editEvent")
    public void editEvent(@RequestBody Event editedEvent) {
        eventService.editEvent(editedEvent);
    }


}
