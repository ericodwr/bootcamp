package com.ocire.boottest.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ProfileDao;
import com.ocire.boottest.model.Profile;

@Repository
@org.springframework.context.annotation.Profile("native-query")
public class ProfileDaoImpl implements ProfileDao {
	@PersistenceContext
	private EntityManager em;


	@Override
	public Profile getById(Long id)  {
		return this.em.getReference(Profile.class, id);
		
	}

	@Override
	public Profile insert(Profile profile)  {
		em.persist(profile);
		return profile;
	}

}
