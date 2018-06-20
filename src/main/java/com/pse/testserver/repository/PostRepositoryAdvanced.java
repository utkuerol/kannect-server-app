package com.pse.testserver.repository;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;

import java.util.List;

public interface PostRepositoryAdvanced {

    List<Post> findAllByUser(User user);

    List<Post> findAllByGroup(Group group);

    List<Post> findAllByEvent(Event event);

    List<User> findAllByName(String name);
}
