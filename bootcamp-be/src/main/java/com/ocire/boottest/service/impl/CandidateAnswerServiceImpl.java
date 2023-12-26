package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ocire.boottest.constant.QuestionTypes;
import com.ocire.boottest.constant.Result;
import com.ocire.boottest.constant.Status;
import com.ocire.boottest.dao.CandidateAnswerDao;
import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.dao.QuestionOptionDao;
import com.ocire.boottest.dao.ResultDao;
import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.dao.StatusDao;
import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.candidate.CandidateAnswerInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateQuestionAndAnswerResDto;
import com.ocire.boottest.model.CandidateAnswer;
import com.ocire.boottest.model.CandidateAssign;
import com.ocire.boottest.model.ProgressStatus;
import com.ocire.boottest.model.Question;
import com.ocire.boottest.model.QuestionOption;
import com.ocire.boottest.model.ResultStatus;
import com.ocire.boottest.model.Review;
import com.ocire.boottest.model.ReviewDetails;
import com.ocire.boottest.model.User;
import com.ocire.boottest.service.CandidateAnswerService;
import com.ocire.boottest.service.MailService;
import com.ocire.boottest.service.PrincipalService;

@Service
public class CandidateAnswerServiceImpl implements CandidateAnswerService {
	private final CandidateAnswerDao candidateAnswerDao;
	private final ReviewDetailsDao reviewDetailsDao;
	private final QuestionDao questionDao;
	private final CandidateAssignDao candidateAssignDao;
	private final QuestionOptionDao questionOptionDao;
	private final ReviewDao reviewDao;
	private final ResultDao resultDao;
	private final StatusDao statusDao;
	private final PrincipalService principalService;
	private final MailService mailService;
	private final UserDao userDao;

	@PersistenceContext
	private EntityManager em;

	public CandidateAnswerServiceImpl(CandidateAnswerDao candidateAnswerDao, ReviewDetailsDao reviewDetailsDao,
			DataSource dataSource, QuestionDao questionDao, CandidateAssignDao candidateAssignDao,
			QuestionOptionDao questionOptionDao, ReviewDao reviewDao, ResultDao resultDao, StatusDao statusDao,
			PrincipalService principalService, MailService mailService, UserDao userDao) {
		this.candidateAnswerDao = candidateAnswerDao;
		this.reviewDetailsDao = reviewDetailsDao;
		this.questionDao = questionDao;
		this.candidateAssignDao = candidateAssignDao;
		this.questionOptionDao = questionOptionDao;
		this.reviewDao = reviewDao;
		this.resultDao = resultDao;
		this.statusDao = statusDao;
		this.principalService = principalService;
		this.mailService = mailService;
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public InsertResDto insertCandidateAnswer(List<CandidateAnswerInsertReqDto> data) {
		final InsertResDto result = new InsertResDto();
		final List<Boolean> scoreList = new ArrayList<>();
		ReviewDetails reviewDetails = null;
		Review review = null;
		for (int i = 0; i < data.size(); i++) {
			final Question question = questionDao.getById(data.get(i).getQuestionId());
			final CandidateAssign candidateAssign = candidateAssignDao.getById(data.get(i).getCandidateAssignId());
			final Review reviewId = reviewDao.getByCandidateId(candidateAssign.getCandidate().getId());
			review = reviewDao.getById(reviewId.getId());
			if (QuestionTypes.OPTION.typeCode.equals(question.getQuestionType().getTypeQuestionCode())) {
				final QuestionOption questionOption = questionOptionDao.getById(data.get(i).getQuestionOptionId());
				final CandidateAnswer answer = new CandidateAnswer();
				answer.setCandidateAssign(candidateAssign);
				answer.setQuestion(question);
				answer.setQuestionOption(questionOption);
				answer.setCreatedBy(principalService.getPrincipal());

				reviewDetails = reviewDetailsDao.getByCandidateAssignId(data.get(i).getCandidateAssignId());
				scoreList.add(questionOption.getOptionCorrect());

				candidateAnswerDao.insertOption(answer);
			} else {
				final CandidateAnswer answer = new CandidateAnswer();
				answer.setCandidateAssign(candidateAssign);
				answer.setQuestion(question);
				answer.setEssayAnswer(data.get(i).getEssayAnswer());
				answer.setCreatedBy(principalService.getPrincipal());
				candidateAnswerDao.insertEssay(answer);
			}
		}

		Float score = 0f;

		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i)) {
				score += 100;
			}
		}

		score = score / scoreList.size();

		if (reviewDetails != null) {
			final ReviewDetails updatedReviewDetails = reviewDetailsDao.getById(reviewDetails.getId());
			updatedReviewDetails.setScore(reviewDetails.getScore());
			updatedReviewDetails.setNotes("Generated By System!");
			updatedReviewDetails.setScore(score);
		}

		final Review updatedReview = reviewDao.getById(review.getId());
		final ResultStatus resultStatus = resultDao.getByCode(Result.NEEDS_REVIEW.roleCode);
		final ProgressStatus progressStatus = statusDao.getByCode(Status.SUBMITTED.roleCode);
		updatedReview.setResult(resultStatus);
		updatedReview.setStatus(progressStatus);

		final User candidate = userDao.getById(review.getCandidate().getId());
		candidate.setIsActive(false);
		candidate.setUpdatedBy(principalService.getPrincipal());

		mailService.sendEmail(review.getReviewer().getUsername(), "Candidate Has Completed All The Answer",
				review.getCandidate().getProfile().getFullName() + " needs review from you!");
		result.setId(null);
		result.setMessage("Candidate successfully submit all answers!");

		return result;
	}

	@Override
	public List<CandidateAnswer> getEssayAnswerCandidate(Long userId) {
		return candidateAnswerDao.getCandidateAnswer(userId);
	}

	@Override
	public List<CandidateQuestionAndAnswerResDto> getCandidateQuestionAnswer(Long userId) {
		final List<CandidateQuestionAndAnswerResDto> candidateQuestionAnswer = new ArrayList<>();
		final List<CandidateAnswer> candidateAnswer = candidateAnswerDao.getCandidateAnswer(userId);

		for (int i = 0; i < candidateAnswer.size(); i++) {
			if (candidateAnswer.get(i).getEssayAnswer() != null) {
				final CandidateQuestionAndAnswerResDto candidateQA = new CandidateQuestionAndAnswerResDto();
				candidateQA.setEssayAnswer(candidateAnswer.get(i).getEssayAnswer());
				candidateQA.setQuestion(candidateAnswer.get(i).getQuestion().getQuestion());
				candidateQuestionAnswer.add(candidateQA);
			}
		}
		return candidateQuestionAnswer;
	}

}
