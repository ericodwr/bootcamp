package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionOptionDao;
import com.ocire.boottest.model.QuestionOption;

@Repository
@Profile("hql-query")
public class QuestionOptionDaoHqlImpl implements QuestionOptionDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<QuestionOption> getQuestionOptionByCandidateId(Long questionId) {
		final String sql = "SELECT tqo FROM QuestionOption tqo WHERE tqo.question.id = :questionId";
		final List<QuestionOption> questionOptionList = this.em.createQuery(sql, QuestionOption.class)
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
