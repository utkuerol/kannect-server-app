package com.pse.testserver.service;

import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Transactional
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


}
