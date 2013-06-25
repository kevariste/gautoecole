package com.geae.domain.dao;

import java.util.Set;

import javax.persistence.EntityManager;

import com.geae.domain.model.BaseModel;

/**
 * Dao generic.
 * @author Evariste
 *
 */
public interface GenericDao {

	public <T extends BaseModel> Long save(T entity);
	public  <T extends BaseModel> T getById(Class<T> clazz,Long id);
	public  <T extends BaseModel> Set<T> getAll(Class<T> clazz);
	public  <T extends BaseModel> void update(T entity);
	public  <T extends BaseModel> void delete(T entity);
	public EntityManager getEntityManager();
	
}
