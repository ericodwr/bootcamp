package com.ocire.boottest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.ocire.boottest.service.QuestionService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("questions")
public class QuestionController {
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@PostMapping
	public ResponseEntity<InsertResDto> insertQuestion(@RequestBody List<QuestionInsertReqDto> data) {
		final InsertResDto result = questionService.insertQuestion(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("detail")
	public ResponseEntity<QuestionResDto> getAllQuestionById(@RequestParam("id") Long id) {
		final QuestionResDto data = questionService.getById(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PostMapping("topic")
	public ResponseEntity<InsertResDto> insertQuestionTopic(@RequestBody QuestionTopicInsertReqDto data) {
		final InsertResDto result = questionService.insertQuestionTopic(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("packet")
	public ResponseEntity<InsertResDto> insertQuestionPacket(@RequestBody QuestionPacketInsertReqDto data) {
		final InsertResDto result = questionService.insertQuestionPacket(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("topic")
	public ResponseEntity<List<QuestionTopicResDto>> getAllQuestionTopic() {
		final List<QuestionTopicResDto> data = questionService.getAllQuestionTopic();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("packet")
	public ResponseEntity<List<QuestionPacketResDto>> getAllQuestionPacket() {
		final List<QuestionPacketResDto> data = questionService.getAllQuestionPacket();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<QuestionResDto>> getAllQuestion() {
		final List<QuestionResDto> data = questionService.getAllQuestion();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("candidate")
	public ResponseEntity<List<QuestionResDto>> getAllQuestionByCandidate() {
		final List<QuestionResDto> data = questionService.getQuestionByCandidate();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("candidate-question-assign")
	public ResponseEntity<List<CandidateQuestionResDto>> getAllQuestionByCandidateAssign() {
		final List<CandidateQuestionResDto> data = questionService.getCandidateQuestion();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<List<QuestionListResDto>> getAllQuestionList() {
		final List<QuestionListResDto> data = questionService.getAllQuestionList();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("by-type")
	public ResponseEntity<List<QuestionResDto>> getAllQuestionByType(@RequestParam("id") Long id) {
		final List<QuestionResDto> data = questionService.getQuestionByType(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
		
	@GetMapping("type")
	public ResponseEntity<List<QuestionTypeResDto>> getAllQuestionType() {
		final List<QuestionTypeResDto> data = questionService.getQuestionTypes();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
