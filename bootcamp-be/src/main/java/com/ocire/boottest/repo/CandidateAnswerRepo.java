package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.CandidateAnswer;

@Repository
public interface CandidateAnswerRepo extends JpaRepository<CandidateAnswer, Long> {
	List<CandidateAnswer> getByCandidateAssignCandidateId(Long userId);
}
