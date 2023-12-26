package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_question_option")
public class QuestionOption extends BaseModel {
	@Column(name = "option_label", nullable = false)
	private String optionLabel;
	
	@Column(name = "option_correct", nullable = false)
	private Boolean optionCorrect;
	
	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;

	public String getOptionLabel() {
		return optionLabel;
	}

	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}

	public Boolean getOptionCorrect() {
		return optionCorrect;
	}

	public void setOptionCorrect(Boolean optionCorrect) {
		this.optionCorrect = optionCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
