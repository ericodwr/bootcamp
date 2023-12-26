package com.ocire.boottest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.candidate.CandidateAnswerInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateDatesResDto;
import com.ocire.boottest.dto.candidate.CandidateTotalQuestionResDto;
import com.ocire.boottest.dto.files.FilesCandidateInsertReqDto;
import com.ocire.boottest.dto.review.ReviewUpdateReqDto;
import com.ocire.boottest.service.CandidateAnswerService;
import com.ocire.boottest.service.CandidateAssignService;
import com.ocire.boottest.service.FileService;
import com.ocire.boottest.service.ReviewService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("answers")
public class CandidateAnswerController {
	private final FileService fileService;
	private final CandidateAnswerService candidateAnswerService;
	private final CandidateAssignService candidateAssignService;
	private final ReviewService reviewService;

	public CandidateAnswerController(FileService fileService, CandidateAnswerService candidateAnswerService,
			ReviewService reviewService, CandidateAssignService candidateAssignService) {
		this.fileService = fileService;
		this.candidateAnswerService = candidateAnswerService;
		this.reviewService = reviewService;
		this.candidateAssignService = candidateAssignService;
	}
	
	@PostMapping("files")
	public ResponseEntity<InsertResDto> insertCandidateFiles(@RequestBody List<FilesCandidateInsertReqDto> data) {
		final InsertResDto result = fileService.insertRequirementFile(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PatchMapping("start")
	public ResponseEntity<UpdateResDto> updateStatusReviewCandidate(@RequestBody ReviewUpdateReqDto data) {
		final UpdateResDto result = reviewService.updateStatus(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PostMapping("submit")
	public ResponseEntity<InsertResDto> insertCandidateAnswer(@RequestBody List<CandidateAnswerInsertReqDto> data) {
		final InsertResDto result = candidateAnswerService.insertCandidateAnswer(data);

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("times")
	public ResponseEntity<CandidateDatesResDto> getCandidateDates() {
		final CandidateDatesResDto data = candidateAssignService.getCandidateDates();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("total-question")
	public ResponseEntity<CandidateTotalQuestionResDto> getCandidateTotal() {
		final CandidateTotalQuestionResDto data = candidateAssignService.candidateQuestions();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
