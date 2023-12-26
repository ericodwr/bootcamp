package com.ocire.boottest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.review.ReviewDetailsResDto;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.dto.review.ReviewUpdateReqDto;
import com.ocire.boottest.dto.status.ResultStatusResDto;
import com.ocire.boottest.service.ReviewDetailsService;
import com.ocire.boottest.service.ReviewService;
import com.ocire.boottest.service.StatusService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("review")
public class ReviewerController {
	private final ReviewService reviewService;
	private final ReviewDetailsService reviewDetailsService;
	private final StatusService statusService;
	
	public ReviewerController(ReviewService reviewService, ReviewDetailsService reviewDetailsService, StatusService statusService) {
		this.reviewService = reviewService;
		this.reviewDetailsService = reviewDetailsService;
		this.statusService = statusService;
	}

	@PatchMapping("update")
	public ResponseEntity<UpdateResDto> updateCandidateReview(@RequestBody ReviewUpdateReqDto data) {
		final UpdateResDto result = reviewService.updatedByReviewer(data);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("detail")
	public ResponseEntity<ReviewResDto> getById(@RequestParam("id") Long id) {
		final ReviewResDto data = reviewService.getReviewByCandidateId(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ReviewResDto> getByCandidateId(@RequestParam("id") Long id) {
		final ReviewResDto data = reviewService.getReviewByCandidateId(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("reviewer")
	public ResponseEntity<List<ReviewResDto>> getByReviewerId() {
		final List<ReviewResDto> data = reviewService.getByReviewerId();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("details")
	public ResponseEntity<List<ReviewDetailsResDto>> getReviewDetailsByCandidateId(@RequestParam("id") Long id) {
		final List<ReviewDetailsResDto> data = reviewDetailsService.getReviewDetailsByCandidateId(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("result")
	public ResponseEntity<List<ResultStatusResDto>> getReviewResultStatus() {
		final List<ResultStatusResDto> data = statusService.getResultStatus();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
