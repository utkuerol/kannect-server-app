package com.pse.testserver.repository.impl;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.UserRepositoryAdvanced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

    @Autowired
    private EntityManager entityManager;
    

    @Override
    public Set<Group> findAllJoinedGroups(User user) {
        String sql = "select groupId  from group_members where user_id like " + user.getId();
        List<User> users = (List<User>) entityManager.createNativeQuery(sql);
        Set<Group> joinedGroups = new HashSet<Group>();
        for(User u : users) {
            joinedGroups = u.getJoinedGroups();
        }
        return joinedGroups;
    }
    @Override
    public Set<Message> filndAllMessages(User user) {
        return null;
    }
    
    @Override
    public Set<Event> findAllparticipatedEvents(User user) {
        return null;
    }
    
    @Override
    public Set<User> findAllSubscriptions(User user) {
        return null;
    }
    
    @Override
    public Set<User> findAllSubscribers(User user) {
        return null;
    }
}
