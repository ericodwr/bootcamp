package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.question.CandidateQuestionResDto;
import com.ocire.boottest.dto.question.QuestionInsertReqDto;
import com.ocire.boottest.dto.question.QuestionListResDto;
import com.ocire.boottest.dto.question.QuestionPacketInsertReqDto;
import com.ocire.boottest.dto.question.QuestionPacketResDto;
import com.ocire.boottest.dto.question.QuestionResDto;
import com.ocire.boottest.dto.question.QuestionTopicInsertReqDto;
import com.ocire.boottest.dto.question.QuestionTopicResDto;
import com.ocire.boottest.dto.question.QuestionTypeResDto;
import com.ocire.boottest.model.QuestionOption;
import com.ocire.boottest.model.QuestionPacket;
import com.ocire.boottest.model.QuestionTopic;
import com.ocire.boottest.model.QuestionType;

public interface QuestionService {
	List<QuestionTypeResDto> getQuestionTypes();

	List<QuestionResDto> getAllQuestion();
	
	List<QuestionResDto> getQuestionByType(Long questionType);
	
	List<QuestionResDto> getQuestionByCandidate();
	
	List<QuestionOption> getQuestionOptionById(Long questionId);
	
	QuestionType getQuestionTypeById(Long id);

	InsertResDto insertQuestionPacket(QuestionPacketInsertReqDto data);
	
	List<QuestionTopicResDto> getAllQuestionTopic();
	
	List<QuestionPacketResDto> getAllQuestionPacket();
	
	InsertResDto insertQuestionTopic(QuestionTopicInsertReqDto data);
	
	QuestionTopic getQuestionTopicById(Long id);
	
	QuestionPacket getQuestionPacketById(Long id);

	InsertResDto insertQuestion(List<QuestionInsertReqDto> data);
	
	List<QuestionListResDto> getAllQuestionList();
	
	List<CandidateQuestionResDto> getCandidateQuestion();
	
	QuestionResDto getById(Long id);
}
