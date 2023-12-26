package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.CandidateAssignDao;
import com.ocire.boottest.dao.CandidateQuestionDao;
import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.dao.QuestionTypeDao;
import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dao.ReviewDetailsDao;
import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.candidate.AssignInsertReqDto;
import com.ocire.boottest.dto.candidate.CandidateDatesResDto;
import com.ocire.boottest.dto.candidate.CandidateTotalQuestionResDto;
import com.ocire.boottest.model.CandidateAssign;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;
import com.ocire.boottest.model.QuestionType;
import com.ocire.boottest.model.Review;
import com.ocire.boottest.model.ReviewDetails;
import com.ocire.boottest.model.User;
import com.ocire.boottest.service.CandidateAssignService;
import com.ocire.boottest.service.PrincipalService;
import com.ocire.boottest.util.DateUtil;

@Service
public class CandidateAssignServiceImpl implements CandidateAssignService {
	@PersistenceContext
	private EntityManager em;
	private PrincipalService principalService;
	private final CandidateAssignDao candidateAssignDao;
	private final ReviewDao reviewDao;
	private final ReviewDetailsDao reviewDetailsDao;
	private final CandidateQuestionDao candidateQuestionDao;
	private final UserDao userDao;
	private final QuestionDao questionDao;
	private final QuestionTypeDao questionTypeDao;

	public CandidateAssignServiceImpl(CandidateAssignDao candidateAssignDao, ReviewDao reviewDao,
			ReviewDetailsDao reviewDetailsDao, CandidateQuestionDao candidateQuestionDao, DataSource dataSource,
			UserDao userDao, QuestionDao questionDao, QuestionTypeDao questionTypeDao,
			PrincipalService principalService) {
		this.candidateAssignDao = candidateAssignDao;
		this.reviewDao = reviewDao;
		this.reviewDetailsDao = reviewDetailsDao;
		this.candidateQuestionDao = candidateQuestionDao;
		this.userDao = userDao;
		this.questionDao = questionDao;
		this.questionTypeDao = questionTypeDao;
		this.principalService = principalService;
	}

	@Transactional
	@Override
	public InsertResDto insertCandidate(AssignInsertReqDto data) {
		List<CandidateAssign> candidateAssignList = new ArrayList<>();
		final User candidate = userDao.getById(data.getCandidateId());
		final User reviewer = userDao.getById(data.getReviewerId());

		InsertResDto result = new InsertResDto();

		for (int i = 0; i < data.getCandidateAssignList().size(); i++) {
			final CandidateAssign candidateAssign = new CandidateAssign();
			final QuestionType questionType = questionTypeDao
					.getByQuestionId(data.getCandidateAssignList().get(i).getQuestionTypeId());
			candidateAssign.setCandidate(candidate);
			candidateAssign.setQuestionType(questionType);
			candidateAssign
					.setStartDate(DateUtil.parseStringToDate(data.getCandidateAssignList().get(i).getStartDate()));
			candidateAssign.setEndDate(DateUtil.parseStringToDate(data.getCandidateAssignList().get(i).getEndDate()));
			candidateAssign.setCreatedBy(principalService.getPrincipal());

			final CandidateAssign newCandidateAssign = candidateAssignDao.insert(candidateAssign);
			candidateAssignList.add(newCandidateAssign);
		}

		final Review review = new Review();

		review.setCandidate(candidate);
		review.setReviewer(reviewer);
		review.setCreatedBy(principalService.getPrincipal());

		final Review newReview = reviewDao.insert(review);

		for (int i = 0; i < candidateAssignList.size(); i++) {
			final ReviewDetails reviewDetails = new ReviewDetails();
			reviewDetails.setReview(newReview);
			reviewDetails.setCandidateAssign(candidateAssignList.get(i));
			reviewDetails.setCreatedBy(principalService.getPrincipal());
			reviewDetailsDao.insert(reviewDetails);
		}

		for (int i = 0; i < candidateAssignList.size(); i++) {
			for (int j = 0; j < data.getQuestionId().size(); j++) {
				final Question question = questionDao.getById(data.getQuestionId().get(j));
				if (candidateAssignList.get(i).getQuestionType().getTypeQuestionCode()
						.equals(question.getQuestionType().getTypeQuestionCode())) {
					final CandidateQuestion candidateQuestion = new CandidateQuestion();
					candidateQuestion.setCandidate(candidate);
					candidateQuestion.setCandidateAssign(candidateAssignList.get(i));
					candidateQuestion.setCreatedBy(principalService.getPrincipal());
					candidateQuestion.setQuestion(question);
					candidateQuestion.setHr(reviewer);
					candidateQuestionDao.insert(candidateQuestion);
				}
			}
		}
		result.setMessage("assign candidate successfully!");
		result.setId(null);

		return result;
	}

	@Override
	public List<CandidateAssign> getAllCandidate() {
		return candidateAssignDao.getAllCandidateAssign();
	}

	@Override
	public List<CandidateAssign> getCandidateId(Long id) {
		return candidateAssignDao.getAllCandidateId(id);
	}

	@Override
	public CandidateDatesResDto getCandidateDates() {
		final CandidateDatesResDto dates = new CandidateDatesResDto();
		System.out.println(principalService.getPrincipal());
		final List<CandidateAssign> assign = candidateAssignDao.getAllCandidateId(principalService.getPrincipal());
		System.out.println(assign);

		for (int i = 0; i < assign.size(); i++) {
			dates.setStartDate(assign.get(i).getStartDate().toString());
			dates.setEndDate(assign.get(i).getEndDate().toString());
		}

		return dates;
	}

	@Override
	public CandidateTotalQuestionResDto candidateQuestions() {
		final CandidateTotalQuestionResDto questions = new CandidateTotalQuestionResDto();
		final List<CandidateQuestion> assign = candidateQuestionDao.getByuserId(principalService.getPrincipal());

		questions.setTotalQuestion(assign.size());

		return questions;
	}

}
