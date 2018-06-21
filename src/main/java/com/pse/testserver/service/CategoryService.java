package com.pse.testserver.service;

import com.pse.testserver.entities.Category;
import com.pse.testserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the category entity, which includes
 * creating, modifying, deleting and other operations which the application
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

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
