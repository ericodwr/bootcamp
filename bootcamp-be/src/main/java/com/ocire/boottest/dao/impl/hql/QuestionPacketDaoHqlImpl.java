package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionPacketDao;
import com.ocire.boottest.model.QuestionPacket;

@Repository
@Profile("hql-query")
public class QuestionPacketDaoHqlImpl implements QuestionPacketDao {
	@PersistenceContext
	private EntityManager em;


	@Override
	public QuestionPacket insert(QuestionPacket questionPacket)  {
		em.persist(questionPacket);
		return questionPacket;
	}

	@Override
	public List<QuestionPacket> getAll()  {
		final String sql = "SELECT qp FROM QuestionPacket qp";
		final List<QuestionPacket> questionPacketList = this.em.createQuery(sql, QuestionPacket.class).getResultList();
		return questionPacketList;
	}

	@Override
	public QuestionPacket getById(Long id)  {
		final QuestionPacket questionPacket = this.em.find(QuestionPacket.class, id);
		return questionPacket;
	}

}
