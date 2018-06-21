package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
    /**
     * @return a {@linkplain java.util.List> of all available categories
     */
    List<Category> findAll();

    /**
     * 
     * @param id unique id of the searched category
     * @return category with the defined id
     */
    Category findById(long id);

    /**
     * 
     * @param name name of the searched category
     * @return category with the defined name
     */
    List<Category> findByName(String name);

}