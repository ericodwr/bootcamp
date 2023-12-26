package com.ocire.boottest.dto.user;

public class UserUpdateReqDto {
	private String fullName;
	private String phoneNumb;
	private String fileName;
	private String fileExtens;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumb() {
		return phoneNumb;
	}

	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

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

}
