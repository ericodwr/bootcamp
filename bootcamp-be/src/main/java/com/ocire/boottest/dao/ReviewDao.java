package com.ocire.boottest.dao;


import java.util.List;

import com.ocire.boottest.model.Review;

public interface ReviewDao {
	Review insert(Review review) ;

	Review getById(Long id) ;
	
	Review getByCandidateId(Long userId);
	
	List<Review> getByReviewerId(Long reviewerId);
}
