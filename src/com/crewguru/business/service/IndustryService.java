/*
 * Created on 10 Aug 2016 ( Time 19:50:09 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.business.service;

import java.util.List;

import com.crewguru.bean.Industry;

/**
 * Business Service Interface for entity Industry.
 */
public interface IndustryService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	Industry findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Industry> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Industry save(Industry entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Industry update(Industry entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Industry create(Industry entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
