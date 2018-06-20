package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import com.pse.testserver.entities.Subcategory;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {
    
    Set<Subcategory> findAll();
    Subcategory findById(long id);
    Set<Subcategory> findByName(String name);
}
