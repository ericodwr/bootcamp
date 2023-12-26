package com.ocire.boottest.dto.review;

public class ReviewDetailsInsertDto {
	private String notes;
	private Float score;
	private Long reviewId;
	private Long candidateAssignId;

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

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getCandidateAssignId() {
		return candidateAssignId;
	}

	public void setCandidateAssignId(Long candidateAssignId) {
		this.candidateAssignId = candidateAssignId;
	}

}
