package com.ocire.boottest.dao.impl.springDataJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.RequirementFileDao;
import com.ocire.boottest.model.RequirementFile;
import com.ocire.boottest.repo.RequirementFileRepo;

@Repository
@Profile("springdatajpa-query")
public class RequirementFileDaoSpringDataJpaImpl implements RequirementFileDao {
	@PersistenceContext
	private EntityManager em;
	private RequirementFileRepo requirementFileRepo;

	public RequirementFileDaoSpringDataJpaImpl(RequirementFileRepo requirementFileRepo) {
		this.requirementFileRepo = requirementFileRepo;
	}
	
	@Override
	public RequirementFile insert(RequirementFile requirementFile) {
		requirementFileRepo.save(requirementFile);
		return requirementFile;
	}
}
