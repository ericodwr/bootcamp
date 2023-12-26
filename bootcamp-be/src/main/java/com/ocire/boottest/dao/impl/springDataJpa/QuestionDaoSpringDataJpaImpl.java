package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;
import com.ocire.boottest.repo.QuestionRepo;

@Repository
@Profile("springdatajpa-query")
public class QuestionDaoSpringDataJpaImpl implements QuestionDao {
	@PersistenceContext
	private EntityManager em;
	private final QuestionRepo questionRepo;

	public QuestionDaoSpringDataJpaImpl(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}

	@Override
	public List<Question> getQuestionByType(Long questionType) {
		final List<Question> questions = questionRepo.getByQuestionTypeId(questionType);
		return questions;

	}
	
	@Override
	public List<Question> getAllQuestion() {
		final List<Question> questions = questionRepo.findAll();
		return questions;
	}
	
	@Override
	public List<CandidateQuestion> getQuestionByCandidate(Long candidateId) {
		final String sql = "SELECT tcq " + "FROM CandidateQuestion tcq " + "WHERE tcq.candidate.id = :candidateId";
		final List<CandidateQuestion> questions = this.em.createQuery(sql, CandidateQuestion.class)
				.setParameter("candidateId", candidateId).getResultList();
		return questions;
	}

	@Override
	public Question insert(Question question) {
		questionRepo.save(question);
		return question;
	}

	@Override
	public Question getById(Long id) {
		final Question question = questionRepo.findById(id).get();
		return question;
	}

}
