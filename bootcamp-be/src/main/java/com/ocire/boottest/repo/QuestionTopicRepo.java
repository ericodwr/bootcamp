package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.QuestionTopic;

@Repository
public interface QuestionTopicRepo extends JpaRepository<QuestionTopic, Long> {
	
}
