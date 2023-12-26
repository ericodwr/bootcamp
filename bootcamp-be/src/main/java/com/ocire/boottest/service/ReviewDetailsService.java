package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.review.ReviewDetailsResDto;

public interface ReviewDetailsService {
	List<ReviewDetailsResDto> getReviewDetailsByCandidateId(Long candidateId);
}
