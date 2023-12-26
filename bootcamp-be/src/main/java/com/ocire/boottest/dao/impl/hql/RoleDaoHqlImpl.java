package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.RoleDao;
import com.ocire.boottest.model.Role;

@Repository
@Profile("hql-query")
public class RoleDaoHqlImpl implements RoleDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Role> getAll() {
		final String sql = "SELECT tr FROM Role tr";
		final List<Role> roleList = this.em.createQuery(sql, Role.class).getResultList();
		return roleList;
	}

	@Override
	public Role getByRoleCode(String roleCode) {
		final String sql = "SELECT r.id, r.roleCode, r.roleName FROM Role r WHERE r.roleCode = :roleCode";

		final Object userObj = this.em.createQuery(sql).setParameter("roleCode", roleCode).getSingleResult();
		final Object[] userArr = (Object[]) userObj;

		Role role = null;

		if (userArr.length > 1) {
			role = new Role();
			role.setId(Long.valueOf(userArr[0].toString()));
			role.setRoleCode(userArr[1].toString());
			role.setRoleName(userArr[2].toString());
		}

		return role;
	}
	
	@Override
	public Role getById(Long id) {
		final Role role = this.em.find(Role.class, id);
		return role;
	}
}
