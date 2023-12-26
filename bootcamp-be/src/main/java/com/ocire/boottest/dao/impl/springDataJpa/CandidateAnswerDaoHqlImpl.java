package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAnswerDao;
import com.ocire.boottest.model.CandidateAnswer;
import com.ocire.boottest.repo.CandidateAnswerRepo;

@Repository
@Profile("springdatajpa-query")
public class CandidateAnswerDaoHqlImpl implements CandidateAnswerDao {
	@PersistenceContext
	private EntityManager em;
	private final CandidateAnswerRepo candidateAnswerRepo;

	public CandidateAnswerDaoHqlImpl(CandidateAnswerRepo candidateAnswerRepo) {
		this.candidateAnswerRepo = candidateAnswerRepo;
	}

	@Override
	public CandidateAnswer insertOption(CandidateAnswer candidateAnswer) {
		candidateAnswerRepo.save(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public CandidateAnswer insertEssay(CandidateAnswer candidateAnswer) {
		candidateAnswerRepo.save(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public List<CandidateAnswer> getCandidateAnswer(Long userId) {
		final List<CandidateAnswer> candidateAnswerList = candidateAnswerRepo.getByCandidateAssignCandidateId(userId);

		return candidateAnswerList;

	}

}
