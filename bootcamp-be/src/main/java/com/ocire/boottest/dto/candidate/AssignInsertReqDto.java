package com.ocire.boottest.dto.candidate;

import java.util.List;

public class AssignInsertReqDto {
	// list candidate
	private List<CandidateAssignInsertReqDto> candidateAssignList;
	private Long reviewerId;
	private Long candidateId;
	private List<Long> questionId;

	public List<CandidateAssignInsertReqDto> getCandidateAssignList() {
		return candidateAssignList;
	}

	public void setCandidateAssignList(List<CandidateAssignInsertReqDto> candidateAssignList) {
		this.candidateAssignList = candidateAssignList;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}
	
	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public List<Long> getQuestionId() {
		return questionId;
	}

	public void setQuestionId(List<Long> questionId) {
		this.questionId = questionId;
	}

}
