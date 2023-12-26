package com.ocire.boottest.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_review")
public class Review extends BaseModel {
	
	@ManyToOne
	@JoinColumn(name = "id_reviewer")
	private User reviewer;
	
	@ManyToOne
	@JoinColumn(name = "id_candidate")
	private User candidate;

	@ManyToOne
	@JoinColumn(name = "id_status")
	private ProgressStatus status;

	@ManyToOne
	@JoinColumn(name = "id_result")
	private ResultStatus result;

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public User getCandidate() {
		return candidate;
	}

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

	public ProgressStatus getStatus() {
		return status;
	}

	public void setStatus(ProgressStatus status) {
		this.status = status;
	}

	public ResultStatus getResult() {
		return result;
	}

	public void setResult(ResultStatus result) {
		this.result = result;
	}

}
