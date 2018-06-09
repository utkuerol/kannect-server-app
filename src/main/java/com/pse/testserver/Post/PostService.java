package com.pse.testserver.Post;

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
