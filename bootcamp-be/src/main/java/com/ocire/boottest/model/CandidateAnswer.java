package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_candidate_answer")
public class CandidateAnswer extends BaseModel {
	
	@Column(name = "essay_answer", nullable = true)
	private String essayAnswer;

	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;

	@ManyToOne
	@JoinColumn(name = "id_question_option")
	private QuestionOption questionOption;

	@ManyToOne
	@JoinColumn(name = "candidate_assign_id")
	private CandidateAssign candidateAssign;

	public String getEssayAnswer() {
		return essayAnswer;
	}

	public void setEssayAnswer(String essayAnswer) {
		this.essayAnswer = essayAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionOption getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(QuestionOption questionOption) {
		this.questionOption = questionOption;
	}

	public CandidateAssign getCandidateAssign() {
		return candidateAssign;
	}

	public void setCandidateAssign(CandidateAssign candidateAssign) {
		this.candidateAssign = candidateAssign;
	}

}
