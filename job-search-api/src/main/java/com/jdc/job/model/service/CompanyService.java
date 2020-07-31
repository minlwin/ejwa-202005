package com.jdc.job.model.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.job.model.dto.CompanyDto;
import com.jdc.job.model.entity.Company;
import com.jdc.job.model.repo.CompanyRepo;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepo repo;
	@Autowired
	private AccountService accounts;

	public Company findById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("There is no Company with this id."));
	}

	@Transactional
	public Company create(CompanyDto dto) {
		Company company = new Company();
		setData(company, dto);
		return repo.save(company);
	}

	@Transactional
	public Company save(int id, CompanyDto dto) {
		Company company = repo.getOne(id);
		setData(company, dto);
		return repo.save(company);
	}

	private void setData(Company company, CompanyDto dto) {
		
		company.setAboutUs(dto.getAboutUs());
		company.setCategory(dto.getCategory());
		company.setFounded(dto.getFounded());
		company.setHomePage(dto.getHomePage());
		company.setLocation(dto.getLocation());
		company.setLogo(dto.getLogo());
		company.setName(dto.getName());
		company.setVisions(dto.getVisions());
		company.setOwner(accounts.getLoginUser());
		
	}

	public Company findByOwner(String owner) {
		return repo.findOneByOwnerEmail(owner);
	}
	
	
}
