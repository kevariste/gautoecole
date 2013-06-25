package com.geae.service;

import org.springframework.transaction.annotation.Transactional;


/**
 * Business generic.
 * @author Evariste
 *
 */
@Transactional
public interface GenericService {

	public String getString();
}
