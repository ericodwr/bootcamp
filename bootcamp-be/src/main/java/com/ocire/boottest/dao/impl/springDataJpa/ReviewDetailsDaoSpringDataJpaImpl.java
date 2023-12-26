package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.model.ReviewDetails;
import com.ocire.boottest.repo.ReviewDetailsRepo;

@Repository
@Profile("springdatajpa-query")
public class ReviewDetailsDaoSpringDataJpaImpl implements ReviewDetailsDao {
	@PersistenceContext
	private EntityManager em;
	private final ReviewDetailsRepo reviewDetailsRepo;

	public ReviewDetailsDaoSpringDataJpaImpl(ReviewDetailsRepo reviewDetailsRepo) {
		this.reviewDetailsRepo = reviewDetailsRepo;
	}
	
	@Override
	public ReviewDetails insert(ReviewDetails reviewDetails) {
		final ReviewDetails newReviewDetails = reviewDetailsRepo.save(reviewDetails);
		return newReviewDetails;
	}

	@Override
	public List<ReviewDetails> getByCandidateIdList(Long candidateId) {

		final List<ReviewDetails> userObjs = reviewDetailsRepo.getByCandidateAssignCandidateId(candidateId);
		return userObjs;
	}

	@Override
	public ReviewDetails getById(Long id) {
		final ReviewDetails reviewDetails = reviewDetailsRepo.findById(id).get();
		return reviewDetails;
	}

	@Override
	public ReviewDetails getByCandidateAssignId(Long candidateId) {
		final String sql = "SELECT trd.id, trd.review.id FROM ReviewDetails trd "
				+ " WHERE trd.candidateAssign.id = :candidateId";

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
