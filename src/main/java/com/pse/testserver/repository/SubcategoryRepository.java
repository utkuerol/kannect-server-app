package com.pse.testserver.repository;

import com.pse.testserver.entities.Subcategory;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {

    List<Subcategory> findAll();

    Subcategory findById(long id);

    List<Subcategory> findByName(String name);
}