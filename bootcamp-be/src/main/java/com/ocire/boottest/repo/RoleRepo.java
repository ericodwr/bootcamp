package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	// get all done
	
	// get by role code done
	Role getByRoleCode(String code);
	
	// get by id
}
