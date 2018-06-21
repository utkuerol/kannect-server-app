package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * The Interface CategoryRepository.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
    /**
     * Find all.
     *
     * @return a list of all available categories
     */
    List<Category> findAll();

    /**
     * find category by id.
     *
     * @param id unique id of the searched category
     * @return category with the defined id
     */
    Category findById(long id);

    /**
     * find category by name.
     *
     * @param name word to be searched in all categories names
     * @return list of all categories containing the string name
     */
    List<Category> findByName(String name);

}