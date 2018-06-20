package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Comment;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.CommentRepository;

public class CommentService {
	@Autowired
    CommentRepository commentRepository;

    @Transactional
    public List<Comment> getAllPosts() {
        return commentRepository.findAll();
    }
}
