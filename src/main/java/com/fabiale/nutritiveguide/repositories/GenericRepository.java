package com.fabiale.nutritiveguide.repositories;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, PK extends Serializable> {
	
	void delete(PK id);
	T read(PK id);
	void create(T t);
	void update(T t);
	List<T> findAll();
}
