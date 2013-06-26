package com.geae.domain.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.geae.domain.dao.GenericDao;
import com.geae.domain.model.BaseModel;

/**
 * 
 * @author Evariste
 *
 */
public abstract class GenericDaoImpl implements GenericDao {

	@PersistenceContext(unitName = "PU")
    protected EntityManager entityManager;
	   
	@Override
	public <T extends BaseModel> Long save(T entity) {		
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public <T extends BaseModel> T getById(Class<T> clazz,Long id) {
		return entityManager.find(clazz, id);		
	}

	
	@SuppressWarnings("unused")
	@Override
	public <T extends BaseModel> List<T> getAll(Class<T> clazz) {
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> cq = cb.createQuery(clazz);
		final Root<T> r = cq.from(clazz);
		final TypedQuery<T> query = entityManager.createQuery(cq); 
		final List<T> result = query.getResultList();
		
		return result;
	}

	@Override
	public <T extends BaseModel> void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public <T extends BaseModel> void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}
}
