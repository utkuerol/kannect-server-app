package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;

import java.util.Set;


import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepositoryAdvanced{
    
    Set<Group> findAllByName(String name);
    Set<Group> findAllByCategory(Category category);
    Set<Group> findAllByNameSortedByCategory(String name, Category category);
    Set<User> findJoinedUsers(Group group);
    Set<Post> findPost(Group group);
}
