package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.ResultStatus;

public interface ResultDao {
	List<ResultStatus> getResultStatus();

	ResultStatus getById(Long id);

	ResultStatus getByCode(String code);
}
