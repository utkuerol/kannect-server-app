package com.pse.testserver.service;

import com.pse.testserver.entities.Subcategory;
import com.pse.testserver.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;


    @Transactional
    public List<Subcategory> getAll() {
        return subcategoryRepository.findAll();
    }

    @Transactional
    public Subcategory findById(long id) {
        return subcategoryRepository.findById(id);
    }

    @Transactional
    public List<Subcategory> findByName(String name) {
        return subcategoryRepository.findByName(name);
    }
}
