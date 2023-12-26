package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.StatusDao;
import com.ocire.boottest.model.ProgressStatus;
import com.ocire.boottest.repo.StatusRepo;

@Repository
@Profile("springdatajpa-query")
public class StatusDaoSpringDataJpaImpl implements StatusDao {
	@PersistenceContext
	private EntityManager em;
	private StatusRepo statusRepo;

	public StatusDaoSpringDataJpaImpl(StatusRepo statusRepo) {
		this.statusRepo = statusRepo;
	}
	
	@Override
	public List<ProgressStatus> getProgressStatus() {
		final List<ProgressStatus> progressStatusList = statusRepo.findAll();
		return progressStatusList;
	}

	@Override
	public ProgressStatus getById(Long id) {
		final ProgressStatus status = statusRepo.findById(id).get();
		return status;
	}

	@Override
	public ProgressStatus getByCode(String code) {
		final ProgressStatus status = statusRepo.getByStatusCode(code);
		
		return status;
	}

}
