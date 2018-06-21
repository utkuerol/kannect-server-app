package com.pse.testserver.service;

import com.pse.testserver.entities.*;
import com.pse.testserver.repository.PostRepository;
import com.pse.testserver.repository.impl.PostRepositoryAdvancedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the post entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly post objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostRepositoryAdvancedImpl postRepositoryADV;

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
    public boolean post(Post post) {
        return false;
    }

    @Transactional
    public boolean deletePost(Post post) {
        return false;
    }

    @Transactional
    public boolean editPost(Post editedPost, Post postToEdit) {
        return false;
    }

    @Transactional
    public boolean likePost(Post post, User user) {
        return false;
    }

    @Transactional
    public boolean unlikePost(Post post, User user) {
        return false;
    }

    @Transactional
    public boolean commentPost(Post post, User user, Comment comment) {
        return false;
    }

}
