package com.ocire.boottest.dto.files;

public class FilesCandidateInsertReqDto {
	private String fileName;
	private String fileExtens;
	private Long typeId;
	private Long candidateId;
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtens() {
		return fileExtens;
	}

	public void setFileExtens(String fileExtens) {
		this.fileExtens = fileExtens;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

}
