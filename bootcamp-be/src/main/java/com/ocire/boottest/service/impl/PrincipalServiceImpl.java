package com.ocire.boottest.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ocire.boottest.service.PrincipalService;

@Service
public class PrincipalServiceImpl implements PrincipalService {

	@Override
	public Long getPrincipal() {
		final Integer id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final Long idFix = (long) id;
		return idFix;
	}
}
