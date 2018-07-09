package com.pse.testserver.service;

import com.pse.testserver.entities.Category;
import com.pse.testserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class implementing the business logic regarding the Category entity, which includes (or may include
 * in future versions) searching, creating, modifying, deleting and other operations which the application needs
 * to perform on mainly category objects.
 * To perform these operations, methods of the injected repository class(es) are to be used.
 */
@Service
public class CategoryService {

    /**
     * Injected CategoryRepository class dependency.
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * @return list of all persisted categories.
     */
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


}
