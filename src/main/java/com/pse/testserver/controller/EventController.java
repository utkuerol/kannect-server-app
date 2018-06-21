package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(value = "name", defaultValue = "") String name) {
        return eventService.getByNameSortedByDate(name);
    }
    
    @PostMapping("/create")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @DeleteMapping("/delete")
    public void deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
    }
   
    @PostMapping("/edit")
    public void editEvent(@RequestBody Event editedEvent) {
        eventService.editEvent(editedEvent);
    }
    

}
