package com.pse.testserver.repository;

import com.pse.testserver.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository <Comment, Integer>{
}
