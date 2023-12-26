package com.ocire.boottest.service;

import java.util.Map;

public interface JwtService {
	public Map<String, Object> parseJwt(final String jwt);
	
	public String generateJwt(final Map<String, Object> claims);
}
