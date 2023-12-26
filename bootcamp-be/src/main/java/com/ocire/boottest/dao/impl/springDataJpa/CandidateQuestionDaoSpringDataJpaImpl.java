package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateQuestionDao;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.repo.CandidateQuestionRepo;

@Repository
@Profile("springdatajpa-query")
public class CandidateQuestionDaoSpringDataJpaImpl implements CandidateQuestionDao {
	@PersistenceContext
	private EntityManager em;
	private final CandidateQuestionRepo candidateQuestionRepo;

	public CandidateQuestionDaoSpringDataJpaImpl(CandidateQuestionRepo candidateQuestionRepo) {
		this.candidateQuestionRepo = candidateQuestionRepo;
	}

	@Override
	public CandidateQuestion insert(CandidateQuestion candidateQuestion) {
		candidateQuestionRepo.save(candidateQuestion);
		return candidateQuestion;
	}

	@Override
	public List<CandidateQuestion> getByuserId(Long userId) {
		final List<CandidateQuestion> questionList = candidateQuestionRepo.getByCandidateId(userId);
		return questionList;
	}

}
