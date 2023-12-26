package com.ocire.boottest.dto.question;

import java.util.List;

public class QuestionResDto {
	private Long id;
	private String question;
	private String questionCode;
	private List<QuestionOptionResDto> questionOption;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public List<QuestionOptionResDto> getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(List<QuestionOptionResDto> questionOption) {
		this.questionOption = questionOption;
	}

}
