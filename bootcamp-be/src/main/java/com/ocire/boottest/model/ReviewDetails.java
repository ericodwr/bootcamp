package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_review_details")
public class ReviewDetails extends BaseModel {
	
	@Column(name = "notes", nullable = true)
	private String notes;

	@Column(name = "score", nullable = true)
	private Float score;
	
	@ManyToOne
	@JoinColumn(name = "id_review")
	private Review review;
	
	@ManyToOne
	@JoinColumn(name = "candidate_assign_id")
	private CandidateAssign candidateAssign;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public CandidateAssign getCandidateAssign() {
		return candidateAssign;
	}

	public void setCandidateAssign(CandidateAssign candidateAssign) {
		this.candidateAssign = candidateAssign;
	}

}
