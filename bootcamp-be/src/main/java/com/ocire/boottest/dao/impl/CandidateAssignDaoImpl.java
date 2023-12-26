package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.model.CandidateAssign;

@Repository
@Profile("native-query")
public class CandidateAssignDaoImpl implements CandidateAssignDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public CandidateAssign insert(CandidateAssign candidateAssign) {
		em.persist(candidateAssign);
		return candidateAssign;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CandidateAssign> getAllCandidateAssign() {
		final String sql = "SELECT * FROM t_candidate_assign tca INNER JOIN t_question_type tqt ON tqt.id = tca.question_type_id";

		return this.em.createNativeQuery(sql, CandidateAssign.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CandidateAssign> getAllCandidateId(Long id) {
		final String sql = "SELECT * FROM t_candidate_assign WHERE candidate_id = :id";

		return this.em.createNativeQuery(sql, CandidateAssign.class).setParameter("id", id).getResultList();
	}
	
	@Override
	public CandidateAssign getById(Long id) {
		final CandidateAssign candidateAssign = this.em.find(CandidateAssign.class, id);
		return candidateAssign;
	}
}
