package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.CandidateAssign;

@Repository
public interface CandidateAssignRepo extends JpaRepository<CandidateAssign, Long> {
	List<CandidateAssign> getByCandidateId(Long id);
}
