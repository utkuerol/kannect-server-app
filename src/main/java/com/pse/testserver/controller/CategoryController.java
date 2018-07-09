package com.pse.testserver.controller;

import com.pse.testserver.entities.Category;
import com.pse.testserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the Category entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class CategoryController {

    /**
     * Injected CategoryService class dependency.
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * Get requests with the "/categories" suffix are mapped to this method.
     * @return list of categories.
     */
    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

}
