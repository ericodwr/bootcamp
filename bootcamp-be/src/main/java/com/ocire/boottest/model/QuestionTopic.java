package com.ocire.boottest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_question_topic")
public class QuestionTopic extends BaseModel {
	@Column(name = "topic_name", length = 30, nullable = false)
	private String topicName;

	@Column(name = "topic_code", length = 5, nullable = false)
	private String topicCode;
	
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicCode() {
		return topicCode;
	}

	public void setTopicCode(String topicCode) {
		this.topicCode = topicCode;
	}

}
