package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
	List<Question> getByQuestionTypeId(Long id);
}
