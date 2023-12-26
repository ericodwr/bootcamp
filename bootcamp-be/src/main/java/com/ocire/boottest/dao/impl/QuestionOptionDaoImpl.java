package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionOptionDao;
import com.ocire.boottest.model.QuestionOption;

@Repository
@Profile("native-query")
public class QuestionOptionDaoImpl implements QuestionOptionDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<QuestionOption> getQuestionOptionByCandidateId(Long questionId) {
		final String sql = "SELECT * FROM t_question_option tqo WHERE tqo.id_question = :questionId";
		@SuppressWarnings("unchecked")
		final List<QuestionOption> questionOptionList = this.em.createNativeQuery(sql, QuestionOption.class)
				.setParameter("questionId", questionId).getResultList();
		return questionOptionList;

	}

	@Override
	public QuestionOption insert(QuestionOption questionOption) {
		em.persist(questionOption);
		return questionOption;
	}
	
	@Override
	public QuestionOption getById(Long id) {
		final QuestionOption questionOption = this.em.find(QuestionOption.class, id);
		return questionOption;
	}

}
