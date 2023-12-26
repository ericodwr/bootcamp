package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.RequirementFile;

@Repository
public interface RequirementFileRepo extends JpaRepository<RequirementFile, Long> {
	
}
