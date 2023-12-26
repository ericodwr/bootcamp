package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.ResultDao;
import com.ocire.boottest.dto.status.ResultStatusResDto;
import com.ocire.boottest.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	private final ResultDao resultDao;

	public StatusServiceImpl(ResultDao resultDao) {
		this.resultDao = resultDao;
	}

	@Override
	public List<ResultStatusResDto> getResultStatus() {
		final List<ResultStatusResDto> resultStatusList = new ArrayList<>();
		resultDao.getResultStatus().forEach(result -> {
			final ResultStatusResDto resultStatusResDto = new ResultStatusResDto();
			resultStatusResDto.setId(result.getId());
			resultStatusResDto.setResultName(result.getResultName());
			resultStatusResDto.setResultCode(result.getResultCode());
			resultStatusList.add(resultStatusResDto);
		});

		return resultStatusList;
	}

}
