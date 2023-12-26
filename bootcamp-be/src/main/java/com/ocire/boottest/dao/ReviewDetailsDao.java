package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.ReviewDetails;

public interface ReviewDetailsDao {
	ReviewDetails insert(ReviewDetails reviewDetails);

	List<ReviewDetails> getByCandidateIdList(Long candidateId);

	ReviewDetails getById(Long id);

	ReviewDetails getByCandidateAssignId(Long candidateId);
}
