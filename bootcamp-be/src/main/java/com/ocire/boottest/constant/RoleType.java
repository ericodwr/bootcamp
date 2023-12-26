package com.ocire.boottest.constant;

public enum RoleType {
	SUPERADMIN("sp1", "Super Admin"), HR("hr1", "Human Resources"), REVIEWER("rv1", "Reviewer"),
	CANDIDATE("cd1", "Candidate");

	public final String roleCode;
	public final String roleName;
	
	private RoleType(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	};
}
