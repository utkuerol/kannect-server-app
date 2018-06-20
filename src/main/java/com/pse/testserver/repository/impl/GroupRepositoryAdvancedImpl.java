package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.EventRepositoryAdvanced;
import com.pse.testserver.repository.GroupRepositoryAdvanced;
import com.pse.testserver.repository.UserRepositoryAdvanced;

import java.util.List;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public class GroupRepositoryAdvancedImpl implements GroupRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Group> findAllByName(String name) {
        return null;
    }
    
    @Override
    public List<User> findJoinedUsers(Group group) {
        return null;
    }
    
    @Override
    public List<Post> findPost(Group group) {
        return null;
    }
    
    @Override
    public List<Group> findAllByCategory(Category category) {
        return null;
    }
    
    @Override
    public List<Group> findAllByNameSortedByCategory(String name, Category category) {
        return null;
    }
}
