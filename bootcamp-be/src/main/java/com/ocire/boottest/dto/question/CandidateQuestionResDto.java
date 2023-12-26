package com.ocire.boottest.dto.question;

public class CandidateQuestionResDto {
	private Long candidateId;
	private Long hrId;
	private Long candidateAssignId;
	private Long questionId;
	private Long typeId;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getHrId() {
		return hrId;
	}

	public void setHrId(Long hrId) {
		this.hrId = hrId;
	}

	public Long getCandidateAssignId() {
		return candidateAssignId;
	}

	public void setCandidateAssignId(Long candidateAssignId) {
		this.candidateAssignId = candidateAssignId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}
