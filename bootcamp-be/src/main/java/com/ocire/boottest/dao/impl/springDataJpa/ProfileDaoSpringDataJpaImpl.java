package com.ocire.boottest.dao.impl.springDataJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ProfileDao;
import com.ocire.boottest.model.Profile;
import com.ocire.boottest.repo.ProfileRepo;

@Repository
@org.springframework.context.annotation.Profile("springdatajpa-query")
public class ProfileDaoSpringDataJpaImpl implements ProfileDao {
	@PersistenceContext
	private EntityManager em;
	private final ProfileRepo profileRepo;

	public ProfileDaoSpringDataJpaImpl(ProfileRepo profileRepo) {
		this.profileRepo = profileRepo;
	}

	@Override
	public Profile getById(Long id) {
		final Profile profile = profileRepo.findById(id).get();
		return profile;
	}

	@Override
	public Profile insert(Profile profile) {
		profileRepo.save(profile);
		return profile;
	}

}
