package com.pse.testserver.service;

import java.util.List;


import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.impl.GroupRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.GroupRepository;

@Service
public class GroupService {
    @Autowired
    GroupRepositoryAdvancedImpl groupRepositoryADV;

    @Autowired
    GroupRepository groupRepository;


    @Transactional
    public List<Group> getAllByName(String name) {
        return groupRepositoryADV.findAllByName(name);
    }

    @Transactional
    public List<User> getJoinedUsers(Group group) {
        return groupRepositoryADV.findJoinedUsers(group);
    }

    @Transactional
    public List<Post> getPost(Group group) {
        return groupRepositoryADV.findPost(group);
    }

    @Transactional
    public List<Group> getAllByCategory(Category category) {
        return groupRepositoryADV.findAllByCategory(category);
    }

    @Transactional
    public List<Group> getAllByNameSortedByCategory(String name, Category category) {
        return groupRepositoryADV.findAllByNameSortedByCategory(name, category);
    }

    @Transactional
    public List<Group> getAll() {
        return groupRepository.findAll();
    }


    @Transactional
    public Group getById(int id) {
        return groupRepository.findById(id);
    }

    @Transactional
    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }

    @Transactional
    public boolean createGroup(Group group) {
        return false;
    }


    @Transactional
    public boolean deleteGroup(Group group) {
        return false;
    }
}
