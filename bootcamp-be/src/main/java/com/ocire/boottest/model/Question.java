package com.ocire.boottest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_question")
public class Question extends BaseModel {

	@Column(name = "question_name", nullable = false)
	private String question;

	@Column(name = "question_code", length = 5, nullable = false)
	private String questionCode;
		
	@ManyToOne
	@JoinColumn(name = "id_question_topic")
	private QuestionTopic questionTopic;
	
	@ManyToOne
	@JoinColumn(name = "id_question_type")
	private QuestionType questionType;

	@ManyToOne
	@JoinColumn(name = "id_question_packet")
	private QuestionPacket questionPacket;

	@Transient
	private List<QuestionOption> questionOption;

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

	public QuestionTopic getQuestionTopic() {
		return questionTopic;
	}

	public void setQuestionTopic(QuestionTopic questionTopic) {
		this.questionTopic = questionTopic;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionPacket getQuestionPacket() {
		return questionPacket;
	}

	public void setQuestionPacket(QuestionPacket questionPacket) {
		this.questionPacket = questionPacket;
	}

	public List<QuestionOption> getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(List<QuestionOption> questionOption) {
		this.questionOption = questionOption;
	}

}
