package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.GroupRepository;

public class GroupService {
	@Autowired
    GroupRepository groupRepository;

    @Transactional
    public List<Post> getAllPosts() {
        return groupRepository.findAll();
    }
}
