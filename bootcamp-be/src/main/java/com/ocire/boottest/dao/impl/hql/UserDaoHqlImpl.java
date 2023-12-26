package com.ocire.boottest.dao.impl.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.model.Profile;
import com.ocire.boottest.model.Role;
import com.ocire.boottest.model.User;

@Repository
@org.springframework.context.annotation.Profile("hql-query")
public class UserDaoHqlImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> getAll() {
		final String sql = "SELECT u FROM User AS u";

		final List<User> users = this.em.createQuery(sql, User.class).getResultList();

		return users;
	}

	@Override
	public List<User> getByRoleCode(String roleCode) {
		final List<User> users = new ArrayList<>();

		final String sql = "SELECT u.id, u.userPassword, u.role.roleCode, u.profile.fullName " + "FROM User u "
				+ "WHERE " + "u.role.roleCode = :roleCode";

		final List<?> userObjs = this.em.createQuery(sql).setParameter("roleCode", roleCode).getResultList();

		if (userObjs.size() > 0) {
			for (Object userObj : userObjs) {
				final Object[] userArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(userArr[0].toString()));
				user.setUserPassword(userArr[1].toString());

				final Role role = new Role();
				role.setRoleCode(userArr[2].toString());

				final Profile profile = new Profile();
				profile.setFullName(userArr[3].toString());

				user.setProfile(profile);
				user.setRole(role);
				users.add(user);
			}
		}

		return users;
	}

	@Override
	public User insert(User user) {
		em.persist(user);
		return user;

	}

	@Override
	public User getByUsername(String username) {
		final String sql = "SELECT u.id, u.userPassword, u.role.roleCode, u.profile.fullName  " + "FROM User u "
				+ "WHERE u.username = :username ";

		final Object userObj = this.em.createQuery(sql).setParameter("username", username).getSingleResult();

		final Object[] userArr = (Object[]) userObj;

		User user = null;

		if (userArr.length > 0) {

			user = new User();
			user.setId(Long.valueOf(userArr[0].toString()));
			user.setUserPassword(userArr[1].toString());

			Role role = new Role();
			role.setRoleCode(userArr[2].toString());
			user.setRole(role);

			Profile profile = new Profile();
			profile.setFullName(userArr[3].toString());
			
			user.setProfile(profile);
		}

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
		final User user = this.em.find(User.class, id);
		return user;
	}

}
