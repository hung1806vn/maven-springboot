package com.sen.app.xslf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sen.app.xslf.repository.GenericDao;

public class GenericService<T, DAO extends GenericDao<T>> implements IGenericService<T> {
	
	@Autowired
    private DAO dao;

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public T save(T entity) {
		return dao.save(entity);
	}

	@Override
	public T findById(long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
	}
	
	
}
