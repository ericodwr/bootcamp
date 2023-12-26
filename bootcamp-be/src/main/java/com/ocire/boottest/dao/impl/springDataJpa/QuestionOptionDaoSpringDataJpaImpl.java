package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionOptionDao;
import com.ocire.boottest.model.QuestionOption;
import com.ocire.boottest.repo.QuestionOptionRepo;

@Repository
@Profile("springdatajpa-query")
public class QuestionOptionDaoSpringDataJpaImpl implements QuestionOptionDao {
	@PersistenceContext
	private EntityManager em;
	private final QuestionOptionRepo questionOptionRepo;

	public QuestionOptionDaoSpringDataJpaImpl(QuestionOptionRepo questionOptionRepo) {
		this.questionOptionRepo = questionOptionRepo;
	}
	
	@Override
	public List<QuestionOption> getQuestionOptionByCandidateId(Long candidateId) {
		final List<QuestionOption> questionOptionList = questionOptionRepo.getByQuestionId(candidateId);
		return questionOptionList;
	}
	
	@Override
	public QuestionOption insert(QuestionOption questionOption) {
		questionOptionRepo.save(questionOption);
		return questionOption;
	}

	@Override
	public QuestionOption getById(Long id) {
		final QuestionOption questionOption = questionOptionRepo.findById(id).get();
		return questionOption;
	}

}
