package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.UserProfileEntity;

/**
 * Repository : UserProfile.
 */
public interface UserProfileJpaRepository extends PagingAndSortingRepository<UserProfileEntity, Integer> {
	
	//UserProfileEntity findByUserId(String userId);

}
