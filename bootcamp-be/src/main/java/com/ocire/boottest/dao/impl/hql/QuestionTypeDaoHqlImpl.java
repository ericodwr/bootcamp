package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionTypeDao;
import com.ocire.boottest.model.QuestionType;

@Repository
@Profile("hql-query")
public class QuestionTypeDaoHqlImpl implements QuestionTypeDao {
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<QuestionType> getAllQuestionType()  {
		final String sql = "SELECT tqt FROM QuestionType tqt";
		
		final List<QuestionType> questionTypeList = this.em.createQuery(sql, QuestionType.class).getResultList();
		return questionTypeList;
	}
	
	@Override
	public QuestionType getByQuestionId(Long id)  {
		final QuestionType questionType = this.em.find(QuestionType.class, id);
		return questionType;
	}

}
