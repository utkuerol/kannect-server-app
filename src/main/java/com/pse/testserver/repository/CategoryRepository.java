package com.pse.testserver.repository;

import com.pse.testserver.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    Category findById(int id);

    /**
     * Find category from database by name.
     *
     * @param name word to be searched in all categories names
     * @return list of all categories containing the string name
     */
    @Query(value = "SELECT * FROM categories WHERE categories.name LIKE %:name%", nativeQuery = true)
    List<Category> findByName(@Param("name") String name);

}