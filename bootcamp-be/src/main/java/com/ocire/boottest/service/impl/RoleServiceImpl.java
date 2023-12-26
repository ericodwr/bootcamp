package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.RoleDao;
import com.ocire.boottest.dto.role.RoleResDto;
import com.ocire.boottest.model.Role;
import com.ocire.boottest.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	private final RoleDao roleDao;

	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<RoleResDto> getAll() {
		final List<RoleResDto> userRoleList = new ArrayList<>();
		roleDao.getAll().forEach(data -> {
			final RoleResDto role = new RoleResDto();
			role.setId(data.getId());
			role.setRoleName(data.getRoleName());
			role.setRoleCode(data.getRoleCode());
			userRoleList.add(role);
		});
		return userRoleList;
	}

	@Override
	public RoleResDto getByRoleCode(String roleCode) {
		final Role roleModel = roleDao.getByRoleCode(roleCode);
		final RoleResDto role = new RoleResDto();
		role.setRoleName(roleModel.getRoleName());
		role.setRoleCode(roleModel.getRoleCode());
		return role;
	}

}
