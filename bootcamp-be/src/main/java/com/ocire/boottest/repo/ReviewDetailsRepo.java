package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.ReviewDetails;

@Repository
public interface ReviewDetailsRepo extends JpaRepository<ReviewDetails, Long> {
	List<ReviewDetails> getByCandidateAssignCandidateId(Long id);
	
}
