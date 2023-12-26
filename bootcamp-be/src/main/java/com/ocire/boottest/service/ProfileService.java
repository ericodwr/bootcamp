package com.ocire.boottest.service;

import com.ocire.boottest.model.Profile;

public interface ProfileService {
	Profile getById(Long id);
	
	Profile insert(Profile profile);
	
	Profile update(Profile profile);
}
