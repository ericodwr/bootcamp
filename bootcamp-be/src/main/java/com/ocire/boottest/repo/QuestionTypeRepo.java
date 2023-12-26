package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.QuestionType;

@Repository
public interface QuestionTypeRepo extends JpaRepository<QuestionType, Long> {
	
}
