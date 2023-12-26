package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.status.ResultStatusResDto;

public interface StatusService {
	List<ResultStatusResDto> getResultStatus();
}
