package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.EventRepository;

public class EventService {
	@Autowired
    EventRepository eventRepository;

    @Transactional
    public List<Post> getAllPosts() {
        return eventRepository.findAll();
    }
}
