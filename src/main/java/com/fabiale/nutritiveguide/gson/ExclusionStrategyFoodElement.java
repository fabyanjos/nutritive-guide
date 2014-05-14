package com.fabiale.nutritiveguide.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ExclusionStrategyFoodElement implements ExclusionStrategy {

	public boolean shouldSkipField(FieldAttributes f) {
		if(f.getAnnotation(ExcludeField.class) != null)
			return true;

		return false;
	}

	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}
