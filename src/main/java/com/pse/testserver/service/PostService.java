package com.pse.testserver.service;

import com.pse.testserver.entities.Event;
import com.pse.testserver.entities.Group;
import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.User;
import com.pse.testserver.repository.PostRepository;
import com.pse.testserver.repository.impl.PostRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostRepositoryAdvancedImpl postRepositoryADV;

    @Transactional
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public List<Post> getAllByUser(User user) {
        return postRepositoryADV.findAllByUser(user);
    }

    @Transactional
    public List<Post> getAllByGroup(Group group) {
        return postRepositoryADV.findAllByGroup(group);
    }

    @Transactional
    public List<Post> getAllByEvent(Event event) {
        return postRepositoryADV.findAllByEvent(event);
    }

    @Transactional
    public List<User> getAllByName(String name) {
        return postRepositoryADV.findAllByName(name);
    }


    @Transactional
    public boolean post(User user, String text) {
        return false;
    }

    @Transactional
    public boolean deletePost(Post post) {
        return false;
    }
    
    @Transactional
    public boolean editPost(Post post) {
        return false;
    }

}
