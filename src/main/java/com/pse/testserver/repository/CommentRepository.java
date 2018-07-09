package com.pse.testserver.repository;

import com.pse.testserver.entities.Comment;
import com.pse.testserver.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,String> {
}
