package com.ocire.boottest.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.RequirementFileDao;
import com.ocire.boottest.model.RequirementFile;

@Repository
@Profile("native-query")
public class RequirementFileDaoImpl implements RequirementFileDao {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public RequirementFile insert(RequirementFile requirementFile)  {
		em.persist(requirementFile);
		return requirementFile;
	}
}
