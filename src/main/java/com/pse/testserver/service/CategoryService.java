package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.CategoryRepository;

public class CategoryService {
	@Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllPosts() {
        return null;
    }
}
