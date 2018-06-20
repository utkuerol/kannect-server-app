package com.pse.testserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pse.testserver.entities.Post;
import com.pse.testserver.entities.Subcategory;
import com.pse.testserver.repository.SubcategoryRepository;

public class SubategoryService {
	@Autowired
	SubcategoryRepository subcategoryRepository;

	@Transactional
	public List<Subcategory> getAllPosts() {
		return subcategoryRepository.findAll();
	}
}
