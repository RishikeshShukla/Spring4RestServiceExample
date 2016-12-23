package com.spring.rest.generic.dao;

import com.spring.rest.model.Entity;

/**
 * @author Rishikesh Shukla
 * 
 */
public interface GenericDAO {

	/**
	 * find entity by Ids
	 * 
	 * @id
	 * @persistentClass
	 * @return Entity
	 */
	Entity findById(long id, Class<?> persistentClass);
	
	/**
	 * find entity by Ids
	 * 
	 * @id
	 * @persistentClass
	 * @return Entity
	 */
	
	Entity findByName(String name, Class<?> persistentClass);

}
