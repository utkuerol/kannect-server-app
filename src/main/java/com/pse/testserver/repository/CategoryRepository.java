package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();

    Category findById(long id);

    List<Category> findByName(String name);

}