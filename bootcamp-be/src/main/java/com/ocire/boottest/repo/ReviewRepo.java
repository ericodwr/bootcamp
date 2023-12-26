package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
	Review getByCandidateId(Long id);
	
	List<Review> getByReviewerId(Long id);
}
