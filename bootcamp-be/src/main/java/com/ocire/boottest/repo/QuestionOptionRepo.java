package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.QuestionOption;

@Repository
public interface QuestionOptionRepo extends JpaRepository<QuestionOption, Long> {
	List<QuestionOption> getByQuestionId(Long id);
}
