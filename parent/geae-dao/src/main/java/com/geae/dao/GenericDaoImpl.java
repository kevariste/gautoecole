package com.geae.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.geae.entity.BaseEntity;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Evariste
 *
 */
@Repository("genericDao")
public class GenericDaoImpl implements GenericDao {

	@PersistenceContext(unitName = "PU")
    private EntityManager entityManager;
	
	@Override
	public <T extends BaseEntity> Long save(T entity) {		
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public <T extends BaseEntity> T getById(Class<T> clazz,Long id) {
		return entityManager.find(clazz, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BaseEntity> Set<T> getAll(Class<T> clazz) {
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> cq = cb.createQuery(clazz);		
		final TypedQuery<T> query = entityManager.createQuery(cq);
        return (Set<T>)query.getResultList();
	}

	@Override
	public <T extends BaseEntity> void update(T entity) {
		entityManager.merge(entity);

	}

	@Override
	public <T extends BaseEntity> void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	@Override
	public EntityManager getEntityManager() {		
		return entityManager;
	}

}
