package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.RoleDao;
import com.ocire.boottest.model.Role;

@Repository
@Profile("native-query")
public class RoleDaoImpl implements RoleDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Role> getAll() {
		final String sql = "SELECT * FROM t_role";
		@SuppressWarnings("unchecked")
		final List<Role> roleList = this.em.createNativeQuery(sql, Role.class).getResultList();
		return roleList;
	}
	
	@Override
	public Role getByRoleCode(String roleCode) {
		final String sql = "SELECT t_role.id, t_role.role_code, t_role.role_name FROM t_role WHERE t_role.role_code = :roleCode";

		final Object userObj = this.em.createNativeQuery(sql).setParameter("roleCode", roleCode).getSingleResult();
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
		final Role role = this.em.getReference(Role.class, id);
		return role;
	}
}
