package com.geae.domain.dao;

import java.util.List;

import com.geae.domain.model.Eleve;

/**
 * 
 * @author E_KONKOLE
 *
 */
public interface EleveDao extends GenericDao {

	List<Eleve> search(String key);
}
