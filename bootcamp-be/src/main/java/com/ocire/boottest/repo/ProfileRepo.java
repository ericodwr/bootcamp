package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
	
}
