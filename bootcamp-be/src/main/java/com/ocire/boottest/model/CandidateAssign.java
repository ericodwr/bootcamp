package com.ocire.boottest.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_candidate_assign")
public class CandidateAssign extends BaseModel {

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private User candidate;

	@ManyToOne
	@JoinColumn(name = "question_type_id")
	private QuestionType questionType;
	
	
	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDateTime endDate;

	public User getCandidate() {
		return candidate;
	}

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
}
