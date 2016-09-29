/*
 * Created on 10 Aug 2016 ( Time 19:50:10 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.crewguru.bean.UserProjects;
import com.crewguru.bean.jpa.UserEntity;
import com.crewguru.bean.jpa.UserProjectsEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UserProjectsServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UserProjectsServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'UserProjectsEntity' to 'UserProjects'
	 * @param userProjectsEntity
	 */
	public UserProjects mapUserProjectsEntityToUserProjects(UserProjectsEntity userProjectsEntity) {
		if(userProjectsEntity == null) {
			return null;
		}

		//--- Generic mapping 
		UserProjects userProjects = map(userProjectsEntity, UserProjects.class);

		//--- Link mapping ( link to User )
		if(userProjectsEntity.getUser() != null) {
			userProjects.setUserId(userProjectsEntity.getUser().getUserId());
		}
		return userProjects;
	}
	
	/**
	 * Mapping from 'UserProjects' to 'UserProjectsEntity'
	 * @param userProjects
	 * @param userProjectsEntity
	 */
	public void mapUserProjectsToUserProjectsEntity(UserProjects userProjects, UserProjectsEntity userProjectsEntity) {
		if(userProjects == null) {
			return;
		}

		//--- Generic mapping 
		map(userProjects, userProjectsEntity);

		//--- Link mapping ( link : userProjects )
		if( hasLinkToUser(userProjects) ) {
			UserEntity user1 = new UserEntity();
			user1.setUserId( userProjects.getUserId() );
			userProjectsEntity.setUser( user1 );
		} else {
			userProjectsEntity.setUser( null );
		}

	}
	
	/**
	 * Verify that User id is valid.
	 * @param User User
	 * @return boolean
	 */
	private boolean hasLinkToUser(UserProjects userProjects) {
		if(userProjects.getUserId() != null) {
			return true;
		}
		return false;
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