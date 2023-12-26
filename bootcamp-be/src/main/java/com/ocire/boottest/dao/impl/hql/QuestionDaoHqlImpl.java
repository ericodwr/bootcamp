package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;

@Repository
@Profile("hql-query")
public class QuestionDaoHqlImpl implements QuestionDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> getQuestionByType(Long questionType) {
		final String sql = "SELECT q " + "FROM Question q " + "WHERE q.questionType.id = :questionType";
		final List<Question> questions = this.em.createQuery(sql, Question.class)
				.setParameter("questionType", questionType).getResultList();
		return questions;

	}

	@Override
	public List<Question> getAllQuestion() {
		final String sql = "SELECT q FROM Question q ";
		final List<Question> questions = this.em.createQuery(sql, Question.class).getResultList();
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
		em.persist(question);
		return question;
	}

	@Override
	public Question getById(Long id) {
		final Question question = this.em.find(Question.class, id);
		return question;
	}

}
