package com.geae.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geae.domain.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geae.domain.dao.GenericDao;
import com.geae.service.GenericService;

/**
 * 
 * @author Evariste
 *
 */
@Service("genericBusiness")
public class GenericServiceImpl implements GenericService {
	private static final Log log = LogFactory.getLog(GenericServiceImpl.class);
	
	@Autowired
	private GenericDao genericDao;
	
	@Override
	public String getString() {		
		log.info("appel reussie");
		
		Eleve e = new Eleve();
		e.setNom("nom");
		e.setPrenom("prenom");
		genericDao.save(e);
		
		log.info(e.getId());
		
		return e.getId().toString();
	}

}
