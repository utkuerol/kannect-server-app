package com.pse.testserver.controller;

import com.pse.testserver.entities.Category;
import com.pse.testserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getCategories(@RequestParam(value = "name", defaultValue = "") String name) {
        return categoryService.getByName(name);
    }

}
