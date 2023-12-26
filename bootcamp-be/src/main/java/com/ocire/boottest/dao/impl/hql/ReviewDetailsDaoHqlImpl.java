package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.model.ReviewDetails;

@Repository
@Profile("hql-query")
public class ReviewDetailsDaoHqlImpl implements ReviewDetailsDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public ReviewDetails insert(ReviewDetails reviewDetails) {
		em.persist(reviewDetails);
		return reviewDetails;
	}

	@Override
	public List<ReviewDetails> getByCandidateIdList(Long candidateId) {
		final String sql = "SELECT trd FROM ReviewDetails trd "
				+ " WHERE trd.candidateAssign.candidate.id = :candidateId";

		final List<ReviewDetails> userObjs = this.em.createQuery(sql, ReviewDetails.class)
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
		final String sql = "SELECT trd.id, trd.review.id FROM ReviewDetails trd " + " WHERE trd.candidateAssign.id = :candidateId";
		
		final Object userObj = this.em.createQuery(sql).setParameter("candidateId", candidateId).getSingleResult();
		final Object[] userArr = (Object[]) userObj;
		
		ReviewDetails reviewDetails = null;

		if (userArr.length > 1) {
			reviewDetails = new ReviewDetails();
			reviewDetails.setId(Long.valueOf(userArr[0].toString()));
		}

		return reviewDetails;
	}

}
