package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.ProgressStatus;

@Repository
public interface StatusRepo extends JpaRepository<ProgressStatus, Long> {
	//find all done
	
	//find by id done
	
	ProgressStatus getByStatusCode(String code);
}
