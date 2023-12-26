package com.ocire.boottest.dto.candidate;

public class CandidateAnswerInsertReqDto {
	private String essayAnswer;
	private Long questionId;
	private Long questionOptionId;
	private Long candidateAssignId;
	
	public String getEssayAnswer() {
		return essayAnswer;
	}

	public void setEssayAnswer(String essayAnswer) {
		this.essayAnswer = essayAnswer;
	}

	public Long getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionOptionId() {
		return questionOptionId;
	}

	public void setQuestionOptionId(Long questionOptionId) {
		this.questionOptionId = questionOptionId;
	}

	public Long getCandidateAssignId() {
		return candidateAssignId;
	}

	public void setCandidateAssignId(Long candidateAssignId) {
		this.candidateAssignId = candidateAssignId;
	}

}
