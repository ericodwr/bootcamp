package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.dto.review.ReviewDetailsResDto;
import com.ocire.boottest.model.ReviewDetails;
import com.ocire.boottest.service.ReviewDetailsService;

@Service
public class ReviewDetailsServiceImpl implements ReviewDetailsService {
	private final ReviewDetailsDao reviewDetailsDao;

	public ReviewDetailsServiceImpl(ReviewDetailsDao reviewDetailsDao) {
			
		this.reviewDetailsDao = reviewDetailsDao;
	}
	
	@Override
	public List<ReviewDetailsResDto> getReviewDetailsByCandidateId(Long candidateId) {
		final List<ReviewDetailsResDto> reviewDetailsRes = new ArrayList<>();
		reviewDetailsDao.getByCandidateIdList(candidateId).forEach(review -> {
			final ReviewDetails reviewDetail = reviewDetailsDao.getById(review.getId());
			final ReviewDetailsResDto newReviewDetail = new ReviewDetailsResDto();
			newReviewDetail.setScore(reviewDetail.getScore());
			newReviewDetail.setNotes(reviewDetail.getNotes());
			newReviewDetail
					.setCandidateName(reviewDetail.getCandidateAssign().getCandidate().getProfile().getFullName());
			newReviewDetail.setQuestionType(reviewDetail.getCandidateAssign().getQuestionType().getTypeQuestionName());
			reviewDetailsRes.add(newReviewDetail);
		});
		
		return reviewDetailsRes;
	}

}
