package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.ProgressStatus;

public interface StatusDao {
	List<ProgressStatus> getProgressStatus();

	ProgressStatus getById(Long id);
	
	ProgressStatus getByCode(String code);
}
