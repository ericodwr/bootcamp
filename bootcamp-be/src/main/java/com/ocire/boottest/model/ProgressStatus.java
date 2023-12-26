package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_progress_status")
public class ProgressStatus extends BaseModel {

	@Column(name = "status_name", length = 30, nullable = false)
	private String statusName;
	
	@Column(name = "status_code", length = 5, nullable = false)
	private String statusCode;

	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
