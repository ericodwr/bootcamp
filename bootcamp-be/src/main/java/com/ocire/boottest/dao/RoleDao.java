package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.Role;

public interface RoleDao {
	List<Role> getAll();

	Role getByRoleCode(String roleCode);

	Role getById(Long id);
}
