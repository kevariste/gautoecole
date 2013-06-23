package com.geae.dao;

import java.util.Set;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import org.geae.entity.BaseEntity;

/**
 * Dao generic.
 * @author Evariste
 *
 */
@Remote(value=GenericDao.class)
public interface GenericDao {

	public <T extends BaseEntity> Long save(T entity);
	public  <T extends BaseEntity> T getById(Class<T> clazz,Long id);
	public  <T extends BaseEntity> Set<T> getAll(Class<T> clazz);
	public  <T extends BaseEntity> void update(T entity);
	public  <T extends BaseEntity> void delete(T entity);
	public EntityManager getEntityManager();
	
}
