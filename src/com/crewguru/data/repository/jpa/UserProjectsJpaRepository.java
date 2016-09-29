package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.UserProjectsEntity;

/**
 * Repository : UserProjects.
 */
public interface UserProjectsJpaRepository extends PagingAndSortingRepository<UserProjectsEntity, Integer> {

}
