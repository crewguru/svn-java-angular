package com.crewguru.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.crewguru.bean.jpa.IndustryEntity;

/**
 * Repository : Industry.
 */
public interface IndustryJpaRepository extends PagingAndSortingRepository<IndustryEntity, Integer> {

}
