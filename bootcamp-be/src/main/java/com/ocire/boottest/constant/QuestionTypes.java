package com.ocire.boottest.constant;

public enum QuestionTypes {
	ESSAY("Essay", "es1"), OPTION("Option", "op1");

	public final String typeName;
	public final String typeCode;

	private QuestionTypes(String typeName, String typeCode) {
		this.typeName = typeName;
		this.typeCode = typeCode;
	}
}
