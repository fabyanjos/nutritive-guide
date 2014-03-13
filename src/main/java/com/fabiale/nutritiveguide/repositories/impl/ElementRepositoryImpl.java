package com.fabiale.nutritiveguide.repositories.impl;

import org.springframework.stereotype.Repository;

import com.fabiale.nutritiveguide.model.Element;
import com.fabiale.nutritiveguide.repositories.ElementRepository;

@Repository
public class ElementRepositoryImpl extends GenericRepositoryImpl<Element, Integer> implements ElementRepository {
	
	public ElementRepositoryImpl() {
		super(Element.class);
	}
}
