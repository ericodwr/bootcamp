package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTopicDao;
import com.ocire.boottest.model.QuestionTopic;
import com.ocire.boottest.repo.QuestionTopicRepo;

@Repository
@Profile("springdatajpa-query")
public class QuestionTopicDaoSpringDataJpaImpl implements QuestionTopicDao {
	@PersistenceContext
	private EntityManager em;
	private final QuestionTopicRepo questionTopicRepo;

	public QuestionTopicDaoSpringDataJpaImpl(QuestionTopicRepo questionTopicRepo) {
		this.questionTopicRepo = questionTopicRepo;
	}
	
	@Override
	public List<QuestionTopic> getAllTopic()  {
		final List<QuestionTopic> questionTopicList = questionTopicRepo.findAll();

		return questionTopicList;
	}
	
	@Override
	public QuestionTopic insert(QuestionTopic questionTopic)  {
		questionTopicRepo.save(questionTopic);
		return questionTopic;
	}

	@Override
	public QuestionTopic getById(Long id)  {
		final QuestionTopic questionTopic = questionTopicRepo.findById(id).get();
		return questionTopic;
	}

}
