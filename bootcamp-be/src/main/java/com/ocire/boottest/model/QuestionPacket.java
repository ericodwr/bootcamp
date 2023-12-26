package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_question_packet")
public class QuestionPacket extends BaseModel {
	
	@Column(name = "packet_question_name", length = 30, nullable = false)
	private String packetQuestionName;

	@Column(name = "packet_question_code", length = 5, nullable = false)
	private String packetQuestionCode;
	
	public String getPacketQuestionName() {
		return packetQuestionName;
	}

	public void setPacketQuestionName(String packetQuestionName) {
		this.packetQuestionName = packetQuestionName;
	}

	public String getPacketQuestionCode() {
		return packetQuestionCode;
	}

	public void setPacketQuestionCode(String packetQuestionCode) {
		this.packetQuestionCode = packetQuestionCode;
	}
}
