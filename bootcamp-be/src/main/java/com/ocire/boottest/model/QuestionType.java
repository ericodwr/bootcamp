package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_question_type")
public class QuestionType extends BaseModel {
	
	@Column(name = "type_question_name", length = 10, nullable = false)
	private String typeQuestionName;
	
	@Column(name = "type_code", length = 5, nullable = false)
	private String typeQuestionCode;

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
