package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.model.CandidateAssign;

@Repository
@Profile("hql-query")
public class CandidateAssignDaoHqlImpl implements CandidateAssignDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public CandidateAssign insert(CandidateAssign candidateAssign) {
		em.persist(candidateAssign);
		return candidateAssign;
	}

	@Override
	public List<CandidateAssign> getAllCandidateAssign() {
		final String sql = "SELECT tca FROM CandidateAssign tca";

		return this.em.createQuery(sql, CandidateAssign.class).getResultList();
	}

	@Override
	public List<CandidateAssign> getAllCandidateId(Long id) {
		final String sql = "SELECT tca FROM CandidateAssign tca WHERE tca.candidate.id = :id";

		return this.em.createQuery(sql, CandidateAssign.class).setParameter("id", id).getResultList();
	}
	
	@Override
	public CandidateAssign getById(Long id) {
		final CandidateAssign candidateAssign = this.em.find(CandidateAssign.class, id);
		return candidateAssign;
	}

}
