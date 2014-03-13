package com.fabiale.nutritiveguide.repositories.impl;

import org.springframework.stereotype.Repository;

import com.fabiale.nutritiveguide.model.Category;
import com.fabiale.nutritiveguide.repositories.CategoryRepository;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category, Integer> implements CategoryRepository {
	
	public CategoryRepositoryImpl() {
		super(Category.class);
	}
}
