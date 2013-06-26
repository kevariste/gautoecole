package com.geae.domain.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.geae.domain.model.Eleve;

/**
 * Metamodel du model "Eleve".
 * @author E_KONKOLE
 *
 */
@StaticMetamodel(Eleve.class)
public class Eleve_ {
	public static volatile SingularAttribute<Eleve,Long> id;
	public static volatile SingularAttribute<Eleve,String> nom;
	public static volatile SingularAttribute<Eleve,String> prenom; 
}
