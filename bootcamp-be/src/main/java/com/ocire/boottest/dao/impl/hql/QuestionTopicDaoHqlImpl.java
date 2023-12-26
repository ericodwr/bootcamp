package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTopicDao;
import com.ocire.boottest.model.QuestionTopic;

@Repository
@Profile("hql-query")
public class QuestionTopicDaoHqlImpl implements QuestionTopicDao {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<QuestionTopic> getAllTopic()  {
		final String sql = "SELECT qt FROM QuestionTopic qt";
		final List<QuestionTopic> questionTopicList = this.em.createQuery(sql, QuestionTopic.class).getResultList();

		return questionTopicList;
	}
	
	@Override
	public QuestionTopic insert(QuestionTopic questionTopic)  {
		em.persist(questionTopic);
		return questionTopic;
	}

	@Override
	public QuestionTopic getById(Long id)  {
		final QuestionTopic questionTopic = this.em.find(QuestionTopic.class, id);
		return questionTopic;
	}

}
