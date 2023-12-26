package com.ocire.boottest.dto.question;

import java.util.List;

public class QuestionInsertReqDto {
	private String question;
	private String questionCode;
	private Long topicId;
	private Long packetId;
	private Long typeId;
	private List<QuestionOptionInsertReqDto> questionOption;

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

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getPacketId() {
		return packetId;
	}

	public void setPacketId(Long packetId) {
		this.packetId = packetId;
	}

	public Long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public List<QuestionOptionInsertReqDto> getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(List<QuestionOptionInsertReqDto> questionOption) {
		this.questionOption = questionOption;
	}

}
