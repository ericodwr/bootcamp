package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.model.Review;
import com.ocire.boottest.repo.ReviewRepo;

@Repository
@Profile("springdatajpa-query")
public class ReviewDaoSpringDataJpaImpl implements ReviewDao {
	@PersistenceContext
	private EntityManager em;
	private ReviewRepo reviewRepo;

	public ReviewDaoSpringDataJpaImpl(ReviewRepo reviewRepo) {
		this.reviewRepo = reviewRepo;
	}

	@Override
	public Review insert(Review review) {
		reviewRepo.save(review);
		return review;
	}

	@Override
	public Review getById(Long id) {
		final Review review = reviewRepo.findById(id).get();
		return review;
	}
	
	@Override
	public Review getByCandidateId(Long candidateId) {
		Review review = reviewRepo.getByCandidateId(candidateId);
		return review;
	}

	@Override
	public List<Review> getByReviewerId(Long reviewerId) {
		List<Review> reviewList = reviewRepo.getByReviewerId(reviewerId);
		return reviewList;
	}

}
