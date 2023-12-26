package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTypeDao;
import com.ocire.boottest.model.QuestionType;

@Repository
@Profile("native-query")
public class QuestionTypeDaoImpl implements QuestionTypeDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<QuestionType> getAllQuestionType() {
		final String sql = "SELECT * FROM t_question_type";

		@SuppressWarnings("unchecked")
		final List<QuestionType> questionTypeList = this.em.createNativeQuery(sql, QuestionType.class).getResultList();
		return questionTypeList;
	}

	@Override
	public QuestionType getByQuestionId(Long id) {
		final QuestionType questionType = this.em.getReference(QuestionType.class, id);
		return questionType;
	}

}
