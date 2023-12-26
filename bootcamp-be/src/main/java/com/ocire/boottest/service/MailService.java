package com.ocire.boottest.service;

public interface MailService {
	void sendEmail(String to, String subject, String text);
}
