package com.geae.dao;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.geae.entity.BaseEntity;

/**
 * 
 * @author Evariste
 *
 */
@Stateless
@LocalBean
public class GenericDaoImpl implements GenericDao {

	@PersistenceContext(unitName = "PU")
    private EntityManager em;
	
	@Override
	public <T extends BaseEntity> Long save(T entity) {		
		em.persist(entity);
		return entity.getId();
	}

	@Override
	public <T extends BaseEntity> T getById(Class<T> clazz,Long id) {
		return em.find(clazz, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BaseEntity> Set<T> getAll(Class<T> clazz) {
		final TypedQuery<T> query = em.createNamedQuery("findAll", clazz);
        return (Set<T>)query.getResultList();
	}

	@Override
	public <T extends BaseEntity> void update(T entity) {
		em.merge(entity);

	}

	@Override
	public <T extends BaseEntity> void delete(T entity) {
		em.remove(em.merge(entity));
	}

	@Override
	public EntityManager getEntityManager() {		
		return em;
	}

}
