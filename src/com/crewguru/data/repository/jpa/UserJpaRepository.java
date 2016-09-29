package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.UserEntity;

/**
 * Repository : User.
 */
public interface UserJpaRepository extends PagingAndSortingRepository<UserEntity, String> {

}
