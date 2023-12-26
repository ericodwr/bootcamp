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
import com.ocire.boottest.dto.candidate.AssignInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateQuestionAndAnswerResDto;
import com.ocire.boottest.service.CandidateAnswerService;
import com.ocire.boottest.service.CandidateAssignService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("candidates")
public class CandidateAssignController {
	private final CandidateAssignService candidateAssignService;
	private final CandidateAnswerService candidateAnswerService;

	public CandidateAssignController(CandidateAssignService candidateAssignService,
			CandidateAnswerService candidateAnswerService) {
		this.candidateAssignService = candidateAssignService;
		this.candidateAnswerService = candidateAnswerService;
	}

	@PostMapping
	public ResponseEntity<InsertResDto> insertCandidateAssign(@RequestBody AssignInsertReqDto data) {
		final InsertResDto result = candidateAssignService.insertCandidate(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("questions")
	public ResponseEntity<List<CandidateQuestionAndAnswerResDto>> getAllQuestionAndAnswer(@RequestParam("id") Long id) {
		final List<CandidateQuestionAndAnswerResDto> data = candidateAnswerService.getCandidateQuestionAnswer(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
