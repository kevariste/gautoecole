package com.geae.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geae.domain.dao.EleveDao;
import com.geae.domain.model.Eleve;
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
	private EleveDao eleveDao;
	
	
	@Override
	public List<Eleve> getEleves(){
		log.debug("Getting all eleves.");
		return eleveDao.search("evariste");  
	}

}
