package com.geae.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.geae.domain.model.Eleve;


/**
 * Business generic.
 * @author Evariste
 *
 */
@Transactional
public interface GenericService {
	List<Eleve> getEleves();  
}
