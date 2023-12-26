package com.ocire.boottest.dao.impl.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAnswerDao;
import com.ocire.boottest.model.CandidateAnswer;

@Repository
@Profile("hql-query")
public class CandidateAnswerDaoHqlImpl implements CandidateAnswerDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public CandidateAnswer insertOption(CandidateAnswer candidateAnswer) {
		em.persist(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public CandidateAnswer insertEssay(CandidateAnswer candidateAnswer) {
		em.persist(candidateAnswer);
		return candidateAnswer;
	}

	@Override
	public List<CandidateAnswer> getCandidateAnswer(Long userId) {
		final List<CandidateAnswer> candidateAnswerList = new ArrayList<>();
		final String sql = "SELECT" + "	tca.essayAnswer, tca.id" + " FROM" + "	CandidateAnswer tca" + " WHERE"
				+ "	tca.candidateAssign.candidate.id = :userId";

		final List<?> userObjs = this.em.createQuery(sql).setParameter("userId", userId).getResultList();

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
