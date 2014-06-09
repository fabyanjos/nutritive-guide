package com.fabiale.nutritiveguide.repositories;

import java.util.List;

import com.fabiale.nutritiveguide.model.Food;

public interface FoodRepository extends GenericRepository<Food, Integer> {
	
	List<Food> findByName(String name, int maxResults);
	public List<Food> findByElement(String elemet, int maxResults, Long categoryId);

}
