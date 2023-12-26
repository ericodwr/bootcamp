package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.QuestionPacketDao;
import com.ocire.boottest.model.QuestionPacket;
import com.ocire.boottest.repo.QuestionPacketRepo;

@Repository
@Profile("springdatajpa-query")
public class QuestionPacketDaoSpringDataJpaImpl implements QuestionPacketDao {
	@PersistenceContext
	private EntityManager em;
	private final QuestionPacketRepo questionPacketRepo;
	
	public QuestionPacketDaoSpringDataJpaImpl(QuestionPacketRepo questionPacketRepo) {
		this.questionPacketRepo = questionPacketRepo;
	}

	@Override
	public QuestionPacket insert(QuestionPacket questionPacket) {
		questionPacketRepo.save(questionPacket);
		return questionPacket;
	}

	@Override
	public List<QuestionPacket> getAll() {
		final List<QuestionPacket> questionPacketList = questionPacketRepo.findAll();
		return questionPacketList;
	}

	@Override
	public QuestionPacket getById(Long id) {
		final QuestionPacket questionPacket = questionPacketRepo.findById(id).get();
		return questionPacket;
	}

}
