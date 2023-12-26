package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.CandidateAnswer;

public interface CandidateAnswerDao {
	CandidateAnswer insertOption(CandidateAnswer candidateAnswer) ;

	CandidateAnswer insertEssay(CandidateAnswer candidateAnswer) ;
	
	List<CandidateAnswer> getCandidateAnswer(Long userId);

}
