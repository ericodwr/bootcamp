package com.ocire.boottest.dao.impl.hql;

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
@Profile("hql-query")
public class CandidateQuestionDaoHqlImpl implements CandidateQuestionDao {
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

		final String sql = "SELECT  " + " tcq.question.id, tcq.question.question " + "FROM  "
				+ "	CandidateQuestion tcq  " + " WHERE tcq.candidate.id = :userId" +  " GROUP BY " + "	tq.question.question, tq.question.id";

		final List<?> userObjs = this.em.createQuery(sql).setParameter("userId", userId).getResultList();

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
