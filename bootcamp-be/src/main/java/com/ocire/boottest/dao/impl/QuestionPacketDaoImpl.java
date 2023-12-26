package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionPacketDao;
import com.ocire.boottest.model.QuestionPacket;

@Repository
@Profile("native-query")
public class QuestionPacketDaoImpl implements QuestionPacketDao {
	@PersistenceContext
	private EntityManager em;


	@Override
	public QuestionPacket insert(QuestionPacket questionPacket)  {
		em.persist(questionPacket);
		return questionPacket;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionPacket> getAll()  {
		final String sql = "SELECT * FROM t_question_packet";
		final List<QuestionPacket> questionPacketList = this.em.createNativeQuery(sql, QuestionPacket.class)
				.getResultList();

		return questionPacketList;
	}

	@Override
	public QuestionPacket getById(Long id)  {
		final QuestionPacket questionPacket = this.em.getReference(QuestionPacket.class, id);
		return questionPacket;
	}

}
