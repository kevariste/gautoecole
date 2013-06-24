package com.geae.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geae.entity.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geae.dao.GenericDao;

/**
 * 
 * @author Evariste
 *
 */
@Service("genericBusiness")
public class GenericBusinessImpl implements GenericBusiness {
	private static final Log log = LogFactory.getLog(GenericBusinessImpl.class);
	
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
