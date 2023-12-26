package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.QuestionType;

public interface QuestionTypeDao {
	List<QuestionType> getAllQuestionType();

	QuestionType getByQuestionId(Long id);
	
}
