package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.CandidateQuestion;

@Repository
public interface CandidateQuestionRepo extends JpaRepository<CandidateQuestion, Long> {
	List<CandidateQuestion> getByCandidateId(Long id);
}
