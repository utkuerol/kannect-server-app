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
        return eventService.getAllByName(name);

    }
    
    @PostMapping("/create")
    public boolean createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/delete")
    public boolean deleteEvent(@RequestBody Event event) {
        return eventService.deleteEvent(event);
    }
   
    @PostMapping("/edit")
    public boolean editEvent(@RequestBody Event editedEvent, @RequestBody Event eventToEdit) {
        return eventService.editEvent(editedEvent, eventToEdit);
    }
    

}
