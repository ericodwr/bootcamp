package com.ocire.boottest.constant;

public enum Status {
	ON_PROGRESS("onp1", "On Progress"), SUBMITTED("sbm1", "Submitted");
	
	public final String roleCode;
	public final String roleName;

	private Status(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
}
