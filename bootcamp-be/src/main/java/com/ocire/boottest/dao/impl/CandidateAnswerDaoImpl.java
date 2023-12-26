package com.ocire.boottest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAnswerDao;
import com.ocire.boottest.model.CandidateAnswer;

@Repository
@Profile("native-query")
public class CandidateAnswerDaoImpl implements CandidateAnswerDao {
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public CandidateAnswer insertOption(CandidateAnswer candidateAnswer)  {
		em.persist(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public CandidateAnswer insertEssay(CandidateAnswer candidateAnswer)  {
		em.persist(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public List<CandidateAnswer> getCandidateAnswer(Long userId)  {
		final List<CandidateAnswer> candidateAnswerList = new ArrayList<>();
		final String sql = "SELECT" + "	tca.essay_answer, tca.id" + " FROM" + "	t_candidate_answer tca" + " INNER JOIN"
				+ "	t_candidate_assign tca2" + " ON" + "	tca.candidate_assign_id = tca2.id" + " WHERE"
				+ "	tca2.candidate_id = :userId";

		final List<?> userObjs = this.em.createNativeQuery(sql).setParameter("userId", userId).getResultList();
		
		if (userObjs.size() > 0) {
			for (Object userObj : userObjs) {
				final Object[] userArr = (Object[]) userObj;
				final CandidateAnswer candidateAnswer = new CandidateAnswer();
				if (userArr[0] != null) {
					candidateAnswer.setEssayAnswer(userArr[0].toString());
				}
				candidateAnswer.setId(Long.valueOf(userArr[1].toString()));
				
				candidateAnswerList.add(candidateAnswer);
			}
		}
		return candidateAnswerList;

	}

}
