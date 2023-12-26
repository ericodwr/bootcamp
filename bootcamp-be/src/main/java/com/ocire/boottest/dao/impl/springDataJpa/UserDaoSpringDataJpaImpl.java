package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.model.Profile;
import com.ocire.boottest.model.User;
import com.ocire.boottest.repo.UserRepo;

@Repository
@org.springframework.context.annotation.Profile("springdatajpa-query")
public class UserDaoSpringDataJpaImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	private final UserRepo userRepo;

	public UserDaoSpringDataJpaImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public List<User> getAll() {
		final List<User> users = userRepo.findAll();
		return users;
	}
	
	@Override
	public List<User> getByRoleCode(String roleCode) {
		final List<User> users = userRepo.getByRoleRoleCode(roleCode);
		return users;
	}

	@Override
	public User insert(User user) {
		userRepo.save(user);
		return user;

	}

	@Override
	public User getByUsername(String username) {
		final User user = userRepo.getByUsername(username);
		return user;
	}
	
	@Override
	public List<User> getCandidateByReviewerId(Long id) {
		final List<User> users = new ArrayList<>();

		final String sql = "SELECT tr.candidate.id, tr.candidate.profile.fullName " + "FROM Review tr "
				+ "WHERE tr.reviewer.id = :id";
		
		final List<?> userObjs = this.em.createQuery(sql).setParameter("id", id).getResultList();
		
		if (userObjs.size() > 0) {
			for (Object userObj : userObjs) {
				final Object[] userArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(userArr[0].toString()));

				final Profile profile = new Profile();

				profile.setFullName(userArr[1].toString());
				user.setProfile(profile);

				users.add(user);
			}
		}
		return users;

	}

	@Override
	public User getById(Long id) {
		final User user = userRepo.findById(id).get();
		return user;
	}

}
