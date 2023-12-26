package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTopicDao;
import com.ocire.boottest.model.QuestionTopic;

@Repository
@Profile("native-query")
public class QuestionTopicDaoImpl implements QuestionTopicDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionTopic> getAllTopic() {
		final String sql = "SELECT * FROM t_question_topic";
		final List<QuestionTopic> questionTopicList = this.em.createNativeQuery(sql, QuestionTopic.class)
				.getResultList();

		return questionTopicList;
	}

	@Override
	public QuestionTopic insert(QuestionTopic questionTopic) {
		em.persist(questionTopic);
		return questionTopic;
	}

	@Override
	public QuestionTopic getById(Long id) {
		final QuestionTopic questionTopic = this.em.getReference(QuestionTopic.class, id);
		return questionTopic;
	}

}
