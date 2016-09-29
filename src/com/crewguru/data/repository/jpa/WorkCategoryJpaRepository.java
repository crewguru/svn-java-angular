package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.WorkCategoryEntity;

/**
 * Repository : WorkCategory.
 */
public interface WorkCategoryJpaRepository extends PagingAndSortingRepository<WorkCategoryEntity, Integer> {

}
