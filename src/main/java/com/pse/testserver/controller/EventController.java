package com.pse.testserver.controller;

import com.pse.testserver.entities.Event;
import com.pse.testserver.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(value = "name", defaultValue = "") String name) {
        //eventService.getEventsByName(name) ...
        return null;
    }


}
