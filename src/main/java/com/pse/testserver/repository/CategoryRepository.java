package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Simple interface which includes find methods related to category entity.
 * To perform these operations, methods of the spring framework are to be used.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
    /**
     * Find all categories from database.
     *
     * @return a list of all available categories
     */
    List<Category> findAll();

    /**
     * Find category from database by id.
     *
     * @param id unique id of the searched category
     * @return category with the defined id
     */
    Category findById(long id);

    /**
     * Find category from database by name.
     *
     * @param name word to be searched in all categories names
     * @return list of all categories containing the string name
     */
    List<Category> findByName(String name);

}