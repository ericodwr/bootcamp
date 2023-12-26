package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_result_status")
public class ResultStatus extends BaseModel {
	@Column(name = "result_name", length = 20, nullable = false)
	private String resultName;
	
	@Column(name = "result_code", length = 5, nullable = false)
	private String resultCode;

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
}
