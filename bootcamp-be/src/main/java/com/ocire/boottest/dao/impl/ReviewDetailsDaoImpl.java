package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.model.ReviewDetails;

@Repository
@Profile("native-query")
public class ReviewDetailsDaoImpl implements ReviewDetailsDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public ReviewDetails insert(ReviewDetails reviewDetails) {
		em.persist(reviewDetails);
		return reviewDetails;
	}
	
	@Override
	public List<ReviewDetails> getByCandidateIdList(Long candidateId) {
		final String sql = "SELECT * FROM t_review_details trd " + "INNER JOIN t_candidate_assign tca "
				+ "ON trd.candidate_assign_id = tca.id " + "INNER JOIN t_question_type tqt "
				+ "ON tqt.id = tca.question_type_id WHERE tca.candidate_id = :candidateId";
		
		@SuppressWarnings("unchecked")
		final List<ReviewDetails> userObjs = this.em.createNativeQuery(sql, ReviewDetails.class)
				.setParameter("candidateId", candidateId).getResultList();
		
		return userObjs;
	}

	@Override
	public ReviewDetails getById(Long id) {
		final ReviewDetails reviewDetails = this.em.find(ReviewDetails.class, id);
		return reviewDetails;
	}

	@Override
	public ReviewDetails getByCandidateAssignId(Long candidateId) {
		final String sql = "SELECT trd.id, trd.id_review FROM t_review_details trd "
				+ "WHERE trd.candidate_assign_id = :candidateId";

		final Object userObj = this.em.createNativeQuery(sql).setParameter("candidateId", candidateId)
				.getSingleResult();
		final Object[] userArr = (Object[]) userObj;

		ReviewDetails reviewDetails = null;

		if (userArr.length > 0) {
			reviewDetails = new ReviewDetails();
			reviewDetails.setId(Long.valueOf(userArr[0].toString()));
		}

		return reviewDetails;
	}

}
