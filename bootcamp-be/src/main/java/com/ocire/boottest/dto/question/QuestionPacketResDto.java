package com.ocire.boottest.dto.question;

public class QuestionPacketResDto {
	private Long id;
	private String packetName;
	private String packetCode;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPacketName() {
		return packetName;
	}

	public void setPacketName(String packetName) {
		this.packetName = packetName;
	}

	public String getPacketCode() {
		return packetCode;
	}

	public void setPacketCode(String packetCode) {
		this.packetCode = packetCode;
	}

}
