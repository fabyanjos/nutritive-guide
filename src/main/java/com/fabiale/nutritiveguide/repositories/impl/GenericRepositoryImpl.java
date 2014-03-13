package com.fabiale.nutritiveguide.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.nutritiveguide.repositories.GenericRepository;

@Transactional
public abstract class GenericRepositoryImpl<T, PK extends Serializable> implements GenericRepository<T, PK> {

	@Autowired private SessionFactory sessionFactory;
	private Class<T> type;
	
	public GenericRepositoryImpl() {
	}
	
	public GenericRepositoryImpl(Class<T> type) {
		this.type = type;
	}
	
    protected Session getSession() {
        if (sessionFactory == null)
            throw new IllegalStateException("SessionFactory has not been set on Repository before usage");
        return sessionFactory.getCurrentSession();
    }

	protected Class<T> getType() {
		return this.type;
	}

	public void delete(PK id) {
		T obj = this.read(id);
		this.getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public T read(PK id) {
		return (T) this.getSession().get(type, id);
	}

	public void create(T obj) {
		this.getSession().save(obj);
	}
	
	public void update(T obj) {
		this.getSession().update(obj);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) this.getSession().createCriteria(getType()).list();
	}
}