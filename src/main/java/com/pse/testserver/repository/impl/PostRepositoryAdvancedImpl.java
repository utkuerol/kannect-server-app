package com.pse.testserver.repository.impl;

import java.util.Set;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.PostRepositoryAdvanced;

public class PostRepositoryAdvancedImpl implements PostRepositoryAdvanced {

    @Override
    public Set<Post> findAllByUser(User user) {
        return null;
    }
    
    @Override
    public Set<Post> findAllByGroup(Group group) {
        return null;
    }
    
    @Override
    public Set<Post> findAllByEvent(Event event) {
        return null;
    }
    
    @Override
    public Set<User> findAllByName(String name) {
        return null;
    }
}
