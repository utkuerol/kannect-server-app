package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Post;
import com.pse.testserver.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public List<Category> getAllPosts() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
