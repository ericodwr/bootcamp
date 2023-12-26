package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ocire.boottest.constant.QuestionTypes;
import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.dao.ResultDao;
import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.dao.StatusDao;
import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.dto.review.ReviewUpdateReqDto;
import com.ocire.boottest.model.CandidateAssign;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.ProgressStatus;
import com.ocire.boottest.model.ResultStatus;
import com.ocire.boottest.model.Review;
import com.ocire.boottest.model.ReviewDetails;
import com.ocire.boottest.service.PrincipalService;
import com.ocire.boottest.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	private final ReviewDao reviewDao;
	private final ReviewDetailsDao reviewDetailsDao;
	private final ResultDao resultDao;
	private final StatusDao statusDao;
	private final CandidateAssignDao candidateAssignDao;
	private final PrincipalService principalService;
	@PersistenceContext
	private EntityManager em;

	public ReviewServiceImpl(ReviewDao reviewDao, ReviewDetailsDao reviewDetailsDao, DataSource dataSource,
			ResultDao resultDao, StatusDao statusDao, CandidateAssignDao candidateAssignDao,
			PrincipalService principalService) {
		this.reviewDao = reviewDao;
		this.reviewDetailsDao = reviewDetailsDao;
		this.resultDao = resultDao;
		this.statusDao = statusDao;
		this.candidateAssignDao = candidateAssignDao;
		this.principalService = principalService;
	}

	@Override
	public List<CandidateQuestion> showCandidateQuestionAnswer(Long candidateId) {
		return null;
	}

	@Transactional
	@Override
	public UpdateResDto updateResult(ReviewUpdateReqDto data) {
		final UpdateResDto result = new UpdateResDto();

		final Review review = reviewDao.getByCandidateId(data.getCandidateId());

		final Review updatedReview = reviewDao.getById(review.getId());

		final ResultStatus resultStatus = resultDao.getById(data.getResultId());
		updatedReview.setResult(resultStatus);
		updatedReview.setUpdatedBy(principalService.getPrincipal());

		em.flush();
		result.setVer(updatedReview.getVer());
		result.setMessage("update result review successfully");

		return result;
	}

	@Transactional
	@Override
	public UpdateResDto updateStatus(ReviewUpdateReqDto data) {
		final UpdateResDto result = new UpdateResDto();

		final Review review = reviewDao.getByCandidateId(data.getCandidateId());
		System.out.println(review);
		final Review updatedReview = reviewDao.getById(review.getId());

		final ProgressStatus status = statusDao.getById(data.getStatusId());

		updatedReview.setStatus(status);
		updatedReview.setUpdatedBy(principalService.getPrincipal());

		em.flush();
		result.setVer(updatedReview.getVer());
		result.setMessage("update status review successfully");

		return result;
	}

	@Transactional
	@Override
	public UpdateResDto updatedByReviewer(ReviewUpdateReqDto data) {
		UpdateResDto result = new UpdateResDto();

		final List<CandidateAssign> candidateAssignList = candidateAssignDao.getAllCandidateId(data.getCandidateId());

		candidateAssignList.forEach(candidateAssign -> {
			if (QuestionTypes.ESSAY.typeCode.equals(candidateAssign.getQuestionType().getTypeQuestionCode())) {
				final ReviewDetails reviewDetails = reviewDetailsDao.getByCandidateAssignId(candidateAssign.getId());
				final ReviewDetails updatedReviewDetails = reviewDetailsDao.getById(reviewDetails.getId());
				updatedReviewDetails.setNotes(data.getNotes());
				updatedReviewDetails.setScore(data.getScore());
				updatedReviewDetails.setUpdatedBy(principalService.getPrincipal());
			}
		});

		final Review review = reviewDao.getByCandidateId(data.getCandidateId());
		final Review updatedReview = reviewDao.getById(review.getId());
		final ResultStatus resultStatus = resultDao.getById(data.getResultId());
		updatedReview.setResult(resultStatus);
		updatedReview.setUpdatedBy(principalService.getPrincipal());

		em.flush();
		result.setVer(updatedReview.getVer());
		result.setMessage("Review updated by Reviewer!");

		return result;
	}

	@Override
	public ReviewResDto getReviewByCandidateId(Long id) {
		final ReviewResDto reviewResponse = new ReviewResDto();
		final Review reviewByCandidate = reviewDao.getByCandidateId(id);
		final Review review = reviewDao.getById(reviewByCandidate.getId());

		reviewResponse.setId(review.getId());
		reviewResponse.setCandidate(review.getCandidate().getProfile().getFullName());
		reviewResponse.setReviewer(review.getReviewer().getProfile().getFullName());
		reviewResponse.setResult(review.getResult().getResultName());
		reviewResponse.setStatus(review.getStatus().getStatusName());

		return reviewResponse;
	}

	@Override
	public List<ReviewResDto> getByReviewerId() {
		final List<ReviewResDto> reviewList = new ArrayList<>();

		final List<Review> reviews = reviewDao.getByReviewerId(principalService.getPrincipal());

		for (int i = 0; i < reviews.size(); i++) {
			final ReviewResDto review = new ReviewResDto();
			review.setCandidateId(reviews.get(i).getCandidate().getId());
			review.setCandidate(reviews.get(i).getCandidate().getProfile().getFullName());
			review.setReviewer(reviews.get(i).getReviewer().getProfile().getFullName());
			review.setId(reviews.get(i).getId());

			if (reviews.get(i).getStatus() != null) {
				System.out.println(reviews.get(i).getStatus().getStatusName());
			}

			if (reviews.get(i).getResult() != null && reviews.get(i).getStatus() != null) {
				review.setResult(reviews.get(i).getResult().getResultName());
				review.setStatus(reviews.get(i).getStatus().getStatusName());
				System.out.println(reviews.get(i).getStatus().getStatusName());
			} else if (reviews.get(i).getStatus() != null) {
				review.setStatus(reviews.get(i).getStatus().getStatusName());
				review.setResult(null);
			} else {
				review.setResult(null);
				review.setStatus(null);				
			}
			reviewList.add(review);
		}

		return reviewList;
	}

	@Override
	public ReviewResDto getReviewById(Long id) {
		final ReviewResDto reviewResDto = new ReviewResDto();
		return reviewResDto;
	}

}
