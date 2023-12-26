package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.RoleDao;
import com.ocire.boottest.model.Role;
import com.ocire.boottest.repo.RoleRepo;

@Repository
@Profile("springdatajpa-query")
public class RoleDaoSpringDataJpaImpl implements RoleDao {
	@PersistenceContext
	private EntityManager em;
	private final RoleRepo roleRepo;

	public RoleDaoSpringDataJpaImpl(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	@Override
	public List<Role> getAll() {
		final List<Role> roleList = roleRepo.findAll();
		return roleList;
	}

	@Override
	public Role getByRoleCode(String roleCode) {
		Role role = roleRepo.getByRoleCode(roleCode);

		return role;
	}

	@Override
	public Role getById(Long id) {
		final Role role = roleRepo.findById(id).get();
		return role;
	}
}
