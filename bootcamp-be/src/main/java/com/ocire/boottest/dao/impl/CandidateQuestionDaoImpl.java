package com.ocire.boottest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateQuestionDao;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;

@Repository
@Profile("native-query")
public class CandidateQuestionDaoImpl implements CandidateQuestionDao {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public CandidateQuestion insert(CandidateQuestion candidateQuestion)  {
		em.persist(candidateQuestion);
		return candidateQuestion;
	}
	
	@Override
	public List<CandidateQuestion> getByuserId(Long userId)  {
		final List<CandidateQuestion> questionList = new ArrayList<>();
		final String sql = "SELECT  " + "	tq.id, tq.question_name  " + "FROM  " + "	t_candidate_question tcq  "
				+ "INNER JOIN " + "	t_question tq  " + "ON  " + "	tcq.id_question = tq.id  " + "WHERE  "
				+ "	tcq.id_candidate = :userId  " + "GROUP BY " + "	tq.question_name, tq.id";

		final List<?> userObjs = this.em.createNativeQuery(sql).setParameter("userId", userId).getResultList();

		if (userObjs.size() > 0) {
			for (Object userObj : userObjs) {
				final Object[] userArr = (Object[]) userObj;
				final CandidateQuestion candidateQuestion = new CandidateQuestion();
				candidateQuestion.setId(Long.valueOf(userArr[0].toString()));

				final Question question = new Question();
				question.setQuestion(userArr[1].toString());
				candidateQuestion.setQuestion(question);
				questionList.add(candidateQuestion);
			}
		}

		return questionList;
	}

}
