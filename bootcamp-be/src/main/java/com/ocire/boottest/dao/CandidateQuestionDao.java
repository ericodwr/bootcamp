package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.CandidateQuestion;

public interface CandidateQuestionDao {
	CandidateQuestion insert(CandidateQuestion candidateQuestion) ;

	List<CandidateQuestion> getByuserId(Long userId) ;
}
