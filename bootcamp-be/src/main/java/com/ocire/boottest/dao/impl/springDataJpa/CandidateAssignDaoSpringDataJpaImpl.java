package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.model.CandidateAssign;
import com.ocire.boottest.repo.CandidateAssignRepo;

@Repository
@Profile("springdatajpa-query")
public class CandidateAssignDaoSpringDataJpaImpl implements CandidateAssignDao {
	@PersistenceContext
	private EntityManager em;
	private final CandidateAssignRepo candidateAssignRepo;

	public CandidateAssignDaoSpringDataJpaImpl(CandidateAssignRepo candidateAssignRepo) {
		this.candidateAssignRepo = candidateAssignRepo;
	}

	@Override
	public CandidateAssign insert(CandidateAssign candidateAssign) {
		candidateAssignRepo.save(candidateAssign);
		return candidateAssign;
	}

	@Override
	public List<CandidateAssign> getAllCandidateAssign() {
		final List<CandidateAssign> candidateAssignList = candidateAssignRepo.findAll();
		return candidateAssignList;
	}

	@Override
	public List<CandidateAssign> getAllCandidateId(Long id) {
		final List<CandidateAssign> candidateAssignList = candidateAssignRepo.getByCandidateId(id);
		return candidateAssignList;
	}

	@Override
	public CandidateAssign getById(Long id) {
		final CandidateAssign candidateAssign = candidateAssignRepo.findById(id).get();
		return candidateAssign;
	}
}
