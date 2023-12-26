package com.ocire.boottest.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_candidate_question")
public class CandidateQuestion extends BaseModel {
	
	@ManyToOne
	@JoinColumn(name = "id_candidate")
	private User candidate;
	
	@ManyToOne
	@JoinColumn(name = "id_hr")
	private User hr;

	@ManyToOne
	@JoinColumn(name = "candidate_assign_id")
	private CandidateAssign candidateAssign;

	@ManyToOne
	@JoinColumn(name = "id_question")
	private Question question;

	public User getCandidate() {
		return candidate;
	}

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

	public User getHr() {
		return hr;
	}

	public void setHr(User hr) {
		this.hr = hr;
	}

	public CandidateAssign getCandidateAssign() {
		return candidateAssign;
	}

	public void setCandidateAssign(CandidateAssign candidateAssign) {
		this.candidateAssign = candidateAssign;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
