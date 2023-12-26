package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.ResultStatus;

@Repository
public interface ResultRepo extends JpaRepository<ResultStatus, Long> {
	
	ResultStatus getByResultCode(String code);
}
