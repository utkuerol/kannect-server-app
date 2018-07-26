package com.pse.testserver.repository;

import com.pse.testserver.entities.Subcategory;
import org.springframework.data.repository.CrudRepository;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {
}
