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

    /**
     * Method to look for a specific category with an id.
     *
     * @param id of the category to look for.
     * @return category with the searched id.
     */
    @Transactional
    public Category getById(long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Method to look for categories, which include the given String in their names.
     * @param name to look for categories.
     * @return list of wanted categories.
     */
    @Transactional
    public List<Category> getByName(String name) {
        return categoryRepository.findByName(name);
    }
}
