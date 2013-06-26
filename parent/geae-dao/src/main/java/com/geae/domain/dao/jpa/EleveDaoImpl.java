package com.geae.domain.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.geae.domain.dao.EleveDao;
import com.geae.domain.model.Eleve;


@Repository("eleveDao")
public class EleveDaoImpl extends GenericDaoImpl implements EleveDao {

	@Override
	public List<Eleve> search(String key) {
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Eleve> cq = cb.createQuery(Eleve.class);  
		final Root<Eleve> root = cq.from(Eleve.class);
		cq.select(root);
		
		final List<Predicate> condList =  new ArrayList<Predicate>();
		
		if(key != null && !key.isEmpty()){
			/*Predicate condNom =cb.like(cb.upper(root.get(Eleve_.nom)), "%"+key.toUpperCase()+"%");
			Predicate condPrenom =cb.like(cb.upper(root.get(Eleve_.prenom)), "%"+key.toUpperCase()+"%");*/
			Predicate condNom =cb.like(cb.upper(root.<String>get("nom")), "%"+key.toUpperCase()+"%");
			Predicate condPrenom =cb.like(cb.upper(root.<String>get("prenom")), "%"+key.toUpperCase()+"%");
			condList.add(cb.or(condNom,condPrenom));			
		}
		
		Predicate[] conditions = new Predicate[condList.size()];
		condList.toArray(conditions);
		cq.where(conditions);
		
		final TypedQuery<Eleve> query = entityManager.createQuery(cq); 
		final List<Eleve> result = query.getResultList();
		
		return result;
		
	}

}
