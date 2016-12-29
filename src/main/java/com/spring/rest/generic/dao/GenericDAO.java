package com.spring.rest.generic.dao;

import java.util.List;

import com.spring.rest.exception.ObjectNotFoundException;
import com.spring.rest.model.Entity;

/**
 * @author Rishikesh Shukla
 * 
 */
public interface GenericDAO {

	/**
	 * find entity by Ids
	 * 
	 * @param id
	 * @param persistentClass
	 * @return Entity
	 */
	Entity findById(long id, Class<?> persistentClass) throws ObjectNotFoundException;

	/**
	 * find entity by Ids
	 * 
	 * @param email
	 * @param persistentClass
	 * @return Entity
	 */

	Entity findByEmail(String email, Class<?> persistentClass) throws ObjectNotFoundException;

	/**
	 * find all entities
	 * 
	 * @param id
	 * @param persistentClass
	 * @return Entity
	 */

	List<? extends Entity> findAll(Class<?> persistentClass);
	
	/**
	 * create a new Entity 
	 * 
	 * @param entity
	 * @return 
	 */
	
	Entity create(Entity entity);
	
	/**
	 * Update a Entity 
	 * 
	 * @param entity
	 * @return 
	 */
	
	void update(Entity entity);
	
	/**
	 * Delete a Entity by primary key 
	 * 
	 * @param id
	 * @param persistentClass
	 * @return 
	 */
	
	void delete(Class<?> persistentClass, long id);
	
	/**
	 * Delete a Entity 
	 * 
	 * @param entity
	 * @return 
	 */
	
	void delete(Entity entity);
	
	
}
