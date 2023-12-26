package com.ocire.boottest.dto.question;

public class QuestionTypeResDto {
	private Long id;
	private String typeQuestionName;
	private String typeQuestionCode;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeQuestionName() {
		return typeQuestionName;
	}

	public void setTypeQuestionName(String typeQuestionName) {
		this.typeQuestionName = typeQuestionName;
	}

	public String getTypeQuestionCode() {
		return typeQuestionCode;
	}

	public void setTypeQuestionCode(String typeQuestionCode) {
		this.typeQuestionCode = typeQuestionCode;
	}

}
