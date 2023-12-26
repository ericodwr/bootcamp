package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.candidate.AssignInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateDatesResDto;
import com.ocire.boottest.dto.candidate.CandidateTotalQuestionResDto;
import com.ocire.boottest.model.CandidateAssign;

public interface CandidateAssignService {
	InsertResDto insertCandidate(AssignInsertReqDto data);

	List<CandidateAssign> getAllCandidate();

	List<CandidateAssign> getCandidateId(Long id);

	CandidateDatesResDto getCandidateDates();

	CandidateTotalQuestionResDto candidateQuestions();

}
