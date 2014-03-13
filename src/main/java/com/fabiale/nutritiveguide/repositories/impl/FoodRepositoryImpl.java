package com.fabiale.nutritiveguide.repositories.impl;

import org.springframework.stereotype.Repository;

import com.fabiale.nutritiveguide.model.Food;
import com.fabiale.nutritiveguide.repositories.FoodRepository;

@Repository
public class FoodRepositoryImpl extends GenericRepositoryImpl<Food, Integer> implements FoodRepository {
	
	public FoodRepositoryImpl() {
		super(Food.class);
	}
}
