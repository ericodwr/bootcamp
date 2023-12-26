package com.ocire.boottest.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_requirement_file")
public class RequirementFile extends BaseModel {
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private FileType type;

	@ManyToOne
	@JoinColumn(name = "file_id")
	private File file;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private User candidate;

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public User getCandidate() {
		return candidate;
	}

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

}
