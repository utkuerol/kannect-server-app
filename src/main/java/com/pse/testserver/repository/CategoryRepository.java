package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
    Set<Category> findAll();
    Category findById(long id);
    Set<Category> findByName(String name);
    
}
