package com.pse.testserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.EventService;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.models.Post.Post")
@RequestMapping
public class EventController {
    
    @Autowired
    EventService eventService;
    
    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(value = "name", defaultValue = "") String name) {
        return eventService.getAllByName(name);

    }
    
    
    

}
