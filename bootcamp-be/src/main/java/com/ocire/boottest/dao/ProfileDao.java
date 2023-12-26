package com.ocire.boottest.dao;


import com.ocire.boottest.model.Profile;

public interface ProfileDao {
	Profile getById(Long id) ;
		
	Profile insert(Profile profile);
	
}
