package com.ocire.boottest.dto.question;

public class QuestionListResDto {
	private String questionName;
	private String questionType;
	private String questionTopic;
	private String questionPacket;

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTopic() {
		return questionTopic;
	}

	public void setQuestionTopic(String questionTopic) {
		this.questionTopic = questionTopic;
	}

	public String getQuestionPacket() {
		return questionPacket;
	}

	public void setQuestionPacket(String questionPacket) {
		this.questionPacket = questionPacket;
	}

}
