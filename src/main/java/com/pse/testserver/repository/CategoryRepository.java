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
     * @return a {@linkplain java.util.List> of all available categories
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
     * @param word word to be searched in all categories names
     * @return {@linkplain java.util.List> of all categories containing the string word
     */
    List<Category> findByName(String word);

}