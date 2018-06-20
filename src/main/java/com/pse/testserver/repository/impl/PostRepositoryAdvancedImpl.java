package com.pse.testserver.repository.impl;

import java.util.Set;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.PostRepositoryAdvanced;


import java.util.List;

public class PostRepositoryAdvancedImpl implements PostRepositoryAdvanced {

    @Override
    public List<Post> findAllByUser(User user) {
        return null;
    }

    @Override
    public List<Post> findAllByGroup(Group group) {
        return null;
    }

    @Override
    public List<Post> findAllByEvent(Event event) {
        return null;
    }

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }
}
