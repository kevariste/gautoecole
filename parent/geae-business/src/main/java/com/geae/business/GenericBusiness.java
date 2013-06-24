package com.geae.business;

import org.springframework.transaction.annotation.Transactional;


/**
 * Business generic.
 * @author Evariste
 *
 */
@Transactional
public interface GenericBusiness {

	public String getString();
}
