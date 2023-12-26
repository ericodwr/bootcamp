package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.role.RoleResDto;

public interface RoleService {
	List<RoleResDto> getAll();

	RoleResDto getByRoleCode(String roleCode);
}
