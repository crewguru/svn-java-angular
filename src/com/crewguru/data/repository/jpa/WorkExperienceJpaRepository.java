package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.WorkExperienceEntity;

/**
 * Repository : WorkExperience.
 */
public interface WorkExperienceJpaRepository extends PagingAndSortingRepository<WorkExperienceEntity, Integer> {

}
