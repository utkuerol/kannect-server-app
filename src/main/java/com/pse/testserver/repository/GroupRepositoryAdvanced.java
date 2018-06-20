package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;

import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepositoryAdvanced{
    
    List<Group> findAllByName(String name);
    List<Group> findAllByCategory(Category category);
    List<Group> findAllByNameSortedByCategory(String name, Category category);
    List<User> findJoinedUsers(Group group);
    List<Post> findPost(Group group);
}
