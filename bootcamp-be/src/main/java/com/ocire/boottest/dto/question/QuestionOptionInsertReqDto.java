package com.ocire.boottest.dto.question;

public class QuestionOptionInsertReqDto {
	private String optionLabel;
	private Boolean optionCorrect;

	public String getOptionLabel() {
		return optionLabel;
	}

	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}

	public Boolean getOptionCorrect() {
		return optionCorrect;
	}
	
	public void setOptionCorrect(Boolean optionCorrect) {
		this.optionCorrect = optionCorrect;
	}

}
