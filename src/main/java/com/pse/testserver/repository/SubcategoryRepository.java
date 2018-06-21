package com.pse.testserver.repository;

import com.pse.testserver.entities.Subcategory;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {

    /**
     * @return a {@linkplain java.util.List> of all available subcategories
     */
    List<Subcategory> findAll();

    /**
     * find subcategory by id
     * @param id unique id of the searched subcategory
     * @return subcategory with the defined id
     */
    Subcategory findById(long id);

    /**
     * 
     * @param name name of the searched subcategory
     * @return {@linkplain java.util.List> of all subcategories containing the string name
     */
    List<Subcategory> findByName(String name);
}