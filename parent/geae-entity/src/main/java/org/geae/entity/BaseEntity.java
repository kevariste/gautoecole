package org.geae.entity;

import java.io.Serializable;

public interface BaseEntity extends Serializable {
	Long getId();
	void setId(Long id);
}
