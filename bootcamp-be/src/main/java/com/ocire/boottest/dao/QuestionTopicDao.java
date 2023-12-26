package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.QuestionTopic;

public interface QuestionTopicDao {
	List<QuestionTopic> getAllTopic() ;

	QuestionTopic insert(QuestionTopic questionTopic) ;
	
	QuestionTopic getById(Long id) ;
}
