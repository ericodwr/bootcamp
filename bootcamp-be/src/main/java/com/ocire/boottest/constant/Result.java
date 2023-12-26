package com.ocire.boottest.constant;

public enum Result {
	NEEDS_REVIEW("nr1", "Needs Review"), REJECTED("rj1", "Rejected"), CONSIDERED("cs1", "Considered"),
	RECOMMENDED("rc1", "Recommended");

	public final String roleCode;
	public final String roleName;
	
	private Result(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
}
