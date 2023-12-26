package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.User;
	
public interface UserDao {
	List<User> getAll();

	List<User> getByRoleCode(String roleCode);

	User insert(User user);
	
	User getByUsername(String username);
	
	User getById(Long id);
	
	List<User> getCandidateByReviewerId(Long id);
}
