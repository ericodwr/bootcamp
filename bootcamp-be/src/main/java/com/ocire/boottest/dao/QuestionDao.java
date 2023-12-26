package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;

public interface QuestionDao {

	List<Question> getAllQuestion() ;

	List<Question> getQuestionByType(Long questionType) ;

	List<CandidateQuestion> getQuestionByCandidate(Long candidateId) ;

	Question insert(Question question);
	
	Question getById(Long id);
}
