/*
 * Created on 10 Aug 2016 ( Time 19:50:09 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.crewguru.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crewguru.bean.Industry;
import com.crewguru.bean.jpa.IndustryEntity;
import com.crewguru.business.service.IndustryService;
import com.crewguru.business.service.mapping.IndustryServiceMapper;
import com.crewguru.data.repository.jpa.IndustryJpaRepository;

/**
 * Implementation of IndustryService
 */
@Component
@Transactional
public class IndustryServiceImpl implements IndustryService {

	@Resource
	private IndustryJpaRepository industryJpaRepository;

	@Resource
	private IndustryServiceMapper industryServiceMapper;
	
	@Override
	public Industry findById(Integer id) {
		IndustryEntity industryEntity = industryJpaRepository.findOne(id);
		return industryServiceMapper.mapIndustryEntityToIndustry(industryEntity);
	}

	@Override
	public List<Industry> findAll() {
		Iterable<IndustryEntity> entities = industryJpaRepository.findAll();
		List<Industry> beans = new ArrayList<Industry>();
		for(IndustryEntity industryEntity : entities) {
			beans.add(industryServiceMapper.mapIndustryEntityToIndustry(industryEntity));
		}
		return beans;
	}

	@Override
	public Industry save(Industry industry) {
		return update(industry) ;
	}

	@Override
	public Industry create(Industry industry) {
		IndustryEntity industryEntity = industryJpaRepository.findOne(industry.getId());
		if( industryEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		industryEntity = new IndustryEntity();
		industryServiceMapper.mapIndustryToIndustryEntity(industry, industryEntity);
		IndustryEntity industryEntitySaved = industryJpaRepository.save(industryEntity);
		return industryServiceMapper.mapIndustryEntityToIndustry(industryEntitySaved);
	}

	@Override
	public Industry update(Industry industry) {
		IndustryEntity industryEntity = industryJpaRepository.findOne(industry.getId());
		industryServiceMapper.mapIndustryToIndustryEntity(industry, industryEntity);
		IndustryEntity industryEntitySaved = industryJpaRepository.save(industryEntity);
		return industryServiceMapper.mapIndustryEntityToIndustry(industryEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		industryJpaRepository.delete(id);
	}

	public IndustryJpaRepository getIndustryJpaRepository() {
		return industryJpaRepository;
	}

	public void setIndustryJpaRepository(IndustryJpaRepository industryJpaRepository) {
		this.industryJpaRepository = industryJpaRepository;
	}

	public IndustryServiceMapper getIndustryServiceMapper() {
		return industryServiceMapper;
	}

	public void setIndustryServiceMapper(IndustryServiceMapper industryServiceMapper) {
		this.industryServiceMapper = industryServiceMapper;
	}

}