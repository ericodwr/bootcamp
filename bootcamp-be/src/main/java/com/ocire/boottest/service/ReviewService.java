package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.dto.review.ReviewUpdateReqDto;
import com.ocire.boottest.model.CandidateQuestion;

public interface ReviewService {
	List<CandidateQuestion> showCandidateQuestionAnswer(Long candidateId);
	
	UpdateResDto updateResult(ReviewUpdateReqDto data);
	
	UpdateResDto updateStatus(ReviewUpdateReqDto data);
	
	ReviewResDto getReviewByCandidateId(Long id);
	
	UpdateResDto updatedByReviewer(ReviewUpdateReqDto data);
	
	List<ReviewResDto> getByReviewerId();

	ReviewResDto getReviewById(Long id);
	
	
}
