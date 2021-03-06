/*
 * Created on 10 Aug 2016 ( Time 19:50:10 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.crewguru.bean.Location;
import com.crewguru.bean.jpa.LocationEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class LocationServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public LocationServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'LocationEntity' to 'Location'
	 * @param locationEntity
	 */
	public Location mapLocationEntityToLocation(LocationEntity locationEntity) {
		if(locationEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Location location = map(locationEntity, Location.class);

		return location;
	}
	
	/**
	 * Mapping from 'Location' to 'LocationEntity'
	 * @param location
	 * @param locationEntity
	 */
	public void mapLocationToLocationEntity(Location location, LocationEntity locationEntity) {
		if(location == null) {
			return;
		}

		//--- Generic mapping 
		map(location, locationEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}