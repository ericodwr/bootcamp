package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;

@Repository
@Profile("native-query")
public class QuestionDaoImpl implements QuestionDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> getQuestionByType(Long questionType) {
		final String sql = "SELECT * FROM t_question q INNER JOIN t_question_type t ON t.id = q.id_question_type  WHERE q.id_question_type = :questionType";

		@SuppressWarnings("unchecked")
		final List<Question> questions = this.em.createNativeQuery(sql, Question.class)
				.setParameter("questionType", questionType).getResultList();
		return questions;

	}

	@Override
	public List<Question> getAllQuestion() {
		final String sql = "SELECT * FROM t_question q INNER JOIN t_question_type t ON t.id = q.id_question_type";

		@SuppressWarnings("unchecked")
		final List<Question> questions = this.em.createNativeQuery(sql, Question.class).getResultList();
		return questions;
	}

	@Override
	public List<CandidateQuestion> getQuestionByCandidate(Long candidateId) {

		final String sql = "SELECT * " + "FROM t_candidate_question tcq  " + "INNER JOIN t_question tq "
				+ "ON tcq.id_question = tq.id " + "INNER JOIN t_question_type t " + "ON tq.id_question_type = t.id  "
				+ "WHERE tcq.id_candidate = :candidateId";
		
		@SuppressWarnings({ "unchecked" })
		final List<CandidateQuestion> questions = this.em.createNativeQuery(sql, CandidateQuestion.class)
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
