package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.candidate.CandidateAnswerInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateDatesResDto;
import com.ocire.boottest.dto.candidate.CandidateQuestionAndAnswerResDto;
import com.ocire.boottest.model.CandidateAnswer;

public interface CandidateAnswerService {
	InsertResDto insertCandidateAnswer(List<CandidateAnswerInsertReqDto> data);

	List<CandidateAnswer> getEssayAnswerCandidate(Long userId);

	List<CandidateQuestionAndAnswerResDto> getCandidateQuestionAnswer(Long userId);

}
