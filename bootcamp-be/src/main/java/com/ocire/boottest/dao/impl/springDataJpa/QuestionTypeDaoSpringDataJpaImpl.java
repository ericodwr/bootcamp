package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTypeDao;
import com.ocire.boottest.model.QuestionType;
import com.ocire.boottest.repo.QuestionTypeRepo;

@Repository
@Profile("springdatajpa-query")
public class QuestionTypeDaoSpringDataJpaImpl implements QuestionTypeDao {
	@PersistenceContext
	private EntityManager em;
	private QuestionTypeRepo questionTypeRepo;
	
	public QuestionTypeDaoSpringDataJpaImpl(QuestionTypeRepo questionTypeRepo) {
		this.questionTypeRepo = questionTypeRepo;
	}

	
	@Override
	public List<QuestionType> getAllQuestionType()  {
		
		final List<QuestionType> questionTypeList = questionTypeRepo.findAll();
		return questionTypeList;
	}
	
	@Override
	public QuestionType getByQuestionId(Long id)  {
		final QuestionType questionType = questionTypeRepo.findById(id).get();
		return questionType;
	}

}
