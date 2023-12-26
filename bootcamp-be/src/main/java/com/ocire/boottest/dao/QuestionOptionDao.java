package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.QuestionOption;

public interface QuestionOptionDao {
	List<QuestionOption> getQuestionOptionByCandidateId(Long questionId);
	
	QuestionOption insert(QuestionOption questionOption);
	
	QuestionOption getById(Long id);
}
