/**
 * 
 */
package com.im.dao;

import java.util.List;

/**
 * @author Shakul Dubey
 * @Details
 * contains common methods used by multiple dao classes. Also, we are using Java generic concept in this interface.
 * E and K letters represent Model class type and primary key type, respectively. 

 *
 */
public interface IGenericDao<E, K> {

	/**
	 * To add an entity
	 * @param entity
	 */
	public void add(E entity);
	
	/**
	 * To save or update an entity. Used when not sure if an entity already exists
	 * @param entity
	 */
	public void saveOrUpdate(E entity);
	
	/**
	 * To update an entity
	 * @param entity
	 */
	public void update(E entity);
	
	/**
	 * To remove an entity
	 * @param entity
	 */
	public void remove(E entity);
	
	/**
	 * To find an entity by primary key 
	 * @param key
	 * @return returns an entity E
	 */
	public E find(K key);
	
	/**
	 * To return all the entities
	 * @return List of entities
	 */
	public List<E> getAll();
}
