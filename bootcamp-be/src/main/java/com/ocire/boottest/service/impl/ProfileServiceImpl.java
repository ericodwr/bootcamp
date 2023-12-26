package com.ocire.boottest.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.ProfileDao;
import com.ocire.boottest.model.Profile;
import com.ocire.boottest.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	private final ProfileDao profileDao;
	@PersistenceContext
	private EntityManager em;

	public ProfileServiceImpl(ProfileDao profileDao, SessionFactory factory) {
		this.profileDao = profileDao;
	}

	@Override
	public Profile getById(Long id) {
		final Profile profile = profileDao.getById(id);
		return profile;
	}

	@Override
	public Profile insert(Profile profile) {
		Profile newProfile = null;

		try {
			this.em.getTransaction().begin();
			newProfile = profileDao.insert(newProfile);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

		Profile addProfile = profileDao.insert(profile);
		return addProfile;
	}

	@Override
	public Profile update(Profile profile) {
		this.em.getTransaction().begin();
		final Profile newProfile = profileDao.getById(profile.getId());

		this.em.getTransaction().commit();
		return newProfile;
	}

}
