package com.spring.rest.generic.dao;

import java.util.List;

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

	Entity findByEmail(String email, Class<?> persistentClass);

	/**
	 * find all entities
	 * 
	 * @id
	 * @persistentClass
	 * @return Entity
	 */

	List<? extends Entity> findAll(Class<?> persistentClass);
	
	/**
	 * create a new Entity 
	 * 
	 * @id
	 * @persistentClass
	 * @return 
	 */
	
	Entity create(Entity entity);
	
	/**
	 * Update a Entity 
	 * 
	 * @id
	 * @persistentClass
	 * @return 
	 */
	
	void update(Entity entity);
	
	/**
	 * Delete a Entity by primary key 
	 * 
	 * @id
	 * @persistentClass
	 * @return 
	 */
	
	void delete(Class<?> persistentClass, long id);
	
	/**
	 * Delete a Entity 
	 * 
	 * @id
	 * @persistentClass
	 * @return 
	 */
	
	void delete(Entity entity);
	
	
}
