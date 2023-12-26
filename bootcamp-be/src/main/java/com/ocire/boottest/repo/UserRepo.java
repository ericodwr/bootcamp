package com.ocire.boottest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	List<User> getByRoleRoleCode(String roleCode);

	User getByUsername(String username);

}
