package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ocire.boottest.constant.QuestionTypes;
import com.ocire.boottest.dao.QuestionDao;
import com.ocire.boottest.dao.QuestionOptionDao;
import com.ocire.boottest.dao.QuestionPacketDao;
import com.ocire.boottest.dao.QuestionTopicDao;
import com.ocire.boottest.dao.QuestionTypeDao;
import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.question.CandidateQuestionResDto;
import com.ocire.boottest.dto.question.QuestionInsertReqDto;
import com.ocire.boottest.dto.question.QuestionListResDto;
import com.ocire.boottest.dto.question.QuestionOptionInsertReqDto;
import com.ocire.boottest.dto.question.QuestionOptionResDto;
import com.ocire.boottest.dto.question.QuestionPacketInsertReqDto;
import com.ocire.boottest.dto.question.QuestionPacketResDto;
import com.ocire.boottest.dto.question.QuestionResDto;
import com.ocire.boottest.dto.question.QuestionTopicInsertReqDto;
import com.ocire.boottest.dto.question.QuestionTopicResDto;
import com.ocire.boottest.dto.question.QuestionTypeResDto;
import com.ocire.boottest.model.CandidateQuestion;
import com.ocire.boottest.model.Question;
import com.ocire.boottest.model.QuestionOption;
import com.ocire.boottest.model.QuestionPacket;
import com.ocire.boottest.model.QuestionTopic;
import com.ocire.boottest.model.QuestionType;
import com.ocire.boottest.service.PrincipalService;
import com.ocire.boottest.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@PersistenceContext
	private EntityManager em;
	private final QuestionTypeDao questionTypeDao;
	private final QuestionDao questionDao;
	private final QuestionOptionDao questionOptionDao;
	private final QuestionPacketDao questionPacketDao;
	private final QuestionTopicDao questionTopicDao;
	private final PrincipalService principalService;

	public QuestionServiceImpl(QuestionTypeDao questionTypeDao, QuestionDao questionDao,
			QuestionOptionDao questionOptionDao, QuestionPacketDao questionPacketDao, QuestionTopicDao questionTopicDao,
			PrincipalService principalService) {
		this.questionTypeDao = questionTypeDao;
		this.questionDao = questionDao;
		this.questionOptionDao = questionOptionDao;
		this.questionPacketDao = questionPacketDao;
		this.questionTopicDao = questionTopicDao;
		this.principalService = principalService;
	}

	@Override
	public List<QuestionTypeResDto> getQuestionTypes() {
		final List<QuestionTypeResDto> questionTypes = new ArrayList<>();
		questionTypeDao.getAllQuestionType().forEach(type -> {
			final QuestionTypeResDto questionType = new QuestionTypeResDto();
			questionType.setId(type.getId());
			questionType.setTypeQuestionName(type.getTypeQuestionName());
			questionType.setTypeQuestionCode(type.getTypeQuestionCode());
			questionTypes.add(questionType);
		});
		return questionTypes;
	}

	@Override
	public List<QuestionResDto> getQuestionByType(Long questionType) {
		final List<QuestionResDto> questionList = new ArrayList<>();
		questionDao.getQuestionByType(questionType).forEach(question -> {
			final QuestionResDto questions = new QuestionResDto();
			questions.setId(question.getId());
			questions.setQuestion(question.getQuestion());
			questions.setQuestionCode(question.getQuestionCode());

			questionList.add(questions);
		});

		return questionList;
	}

	@Override
	public List<QuestionResDto> getAllQuestion() {
		final List<QuestionResDto> questionList = new ArrayList<>();
		questionDao.getAllQuestion().forEach(question -> {
			final QuestionResDto questions = new QuestionResDto();
			questions.setId(question.getId());
			questions.setQuestion(question.getQuestion());
			questions.setQuestionCode(question.getQuestionCode());

			if (question.getQuestionType().getTypeQuestionCode().equals(QuestionTypes.OPTION.typeCode)) {
				final List<QuestionOptionResDto> optionResList = new ArrayList<>();
				questionOptionDao.getQuestionOptionByCandidateId(question.getId()).forEach(option -> {
					final QuestionOptionResDto optionRes = new QuestionOptionResDto();
					optionRes.setOptionLabel(option.getOptionLabel());
					optionRes.setId(option.getId());
					optionResList.add(optionRes);
				});
				questions.setQuestionOption(optionResList);
			}

			questionList.add(questions);
		});
		return questionList;
	}

	@Override
	public List<QuestionResDto> getQuestionByCandidate() {
		final List<CandidateQuestion> candidateQuestionlist = questionDao.getQuestionByCandidate(principalService.getPrincipal());
		final List<QuestionResDto> questionList = new ArrayList<>();

		for (int i = 0; i < candidateQuestionlist.size(); i++) {
			final Question question = candidateQuestionlist.get(i).getQuestion();

			final QuestionResDto questions = new QuestionResDto();
			questions.setId(question.getId());
			questions.setQuestion(question.getQuestion());
			questions.setQuestionCode(question.getQuestionCode());
			
			if (question.getQuestionType().getTypeQuestionCode().equals(QuestionTypes.OPTION.typeCode)) {
				final List<QuestionOptionResDto> optionResList = new ArrayList<>();
				questionOptionDao.getQuestionOptionByCandidateId(question.getId()).forEach(option -> {
					final QuestionOptionResDto optionRes = new QuestionOptionResDto();
					optionRes.setOptionLabel(option.getOptionLabel());
					optionRes.setId(option.getId());
					optionResList.add(optionRes);
				});
				questions.setQuestionOption(optionResList);
			}

			questionList.add(questions);

		}

		return questionList;

	}

	@Override
	public List<QuestionOption> getQuestionOptionById(Long questionId) {
		return questionOptionDao.getQuestionOptionByCandidateId(questionId);
	}

	@Override
	public QuestionType getQuestionTypeById(Long id) {
		return questionTypeDao.getByQuestionId(id);
	}

	@Transactional
	@Override
	public InsertResDto insertQuestionPacket(QuestionPacketInsertReqDto data) {
		InsertResDto result = new InsertResDto();

		QuestionPacket questionPacket = new QuestionPacket();
		questionPacket.setPacketQuestionName(data.getPacketQuestionName());
		questionPacket.setPacketQuestionCode(data.getPacketQuestionCode());
		questionPacket.setCreatedBy(principalService.getPrincipal());

		QuestionPacket newQuestionPacket = questionPacketDao.insert(questionPacket);
		result.setId(newQuestionPacket.getId());
		result.setMessage("Create question packet successfully!");

		return result;
	}

	@Override
	public List<QuestionTopicResDto> getAllQuestionTopic() {
		final List<QuestionTopicResDto> questionTopicList = new ArrayList<>();
		questionTopicDao.getAllTopic().forEach(topic -> {
			final QuestionTopicResDto questionTopic = new QuestionTopicResDto();
			questionTopic.setId(topic.getId());
			questionTopic.setTopicName(topic.getTopicName());
			questionTopic.setTopicCode(topic.getTopicCode());
			questionTopicList.add(questionTopic);
		});
		return questionTopicList;
	}

	@Transactional
	@Override
	public InsertResDto insertQuestionTopic(QuestionTopicInsertReqDto data) {
		InsertResDto result = new InsertResDto();
		QuestionTopic questionTopic = new QuestionTopic();
		questionTopic.setTopicName(data.getTopicName());
		questionTopic.setTopicCode(data.getTopicCode());
		questionTopic.setCreatedBy(principalService.getPrincipal());
		QuestionTopic newQuestiontopic = questionTopicDao.insert(questionTopic);

		result.setId(newQuestiontopic.getId());
		result.setMessage("Insert question topic successfully!");

		return result;
	}

	@Override
	public List<QuestionPacketResDto> getAllQuestionPacket() {
		final List<QuestionPacketResDto> questionPacketList = new ArrayList<>();
		questionPacketDao.getAll().forEach(packet -> {
			final QuestionPacketResDto questionPacket = new QuestionPacketResDto();
			questionPacket.setId(packet.getId());
			questionPacket.setPacketName(packet.getPacketQuestionName());
			questionPacket.setPacketCode(packet.getPacketQuestionCode());
			questionPacketList.add(questionPacket);
		});

		return questionPacketList;
	}

	@Override
	public QuestionTopic getQuestionTopicById(Long id) {
		return questionTopicDao.getById(id);
	}

	@Override
	public QuestionPacket getQuestionPacketById(Long id) {
		return questionPacketDao.getById(id);
	}

	@Transactional
	@Override
	public InsertResDto insertQuestion(List<QuestionInsertReqDto> dataList) {
		InsertResDto result = new InsertResDto();

		dataList.forEach(data -> {

			Question question = new Question();
			question.setQuestion(data.getQuestion());
			question.setQuestionCode(data.getQuestionCode());

			final QuestionTopic questionTopic = questionTopicDao.getById(data.getTopicId());
			final QuestionPacket questionPacket = questionPacketDao.getById(data.getPacketId());
			final QuestionType questionType = questionTypeDao.getByQuestionId(data.getTypeId());
			question.setQuestionPacket(questionPacket);
			question.setQuestionTopic(questionTopic);
			question.setQuestionType(questionType);
			question.setCreatedBy(principalService.getPrincipal());

			Question newQuestion = questionDao.insert(question);

			result.setId(null);
			result.setMessage("Insert question success");

			if (data.getQuestionOption() != null) {
				for (int i = 0; i < data.getQuestionOption().size(); i++) {
					final QuestionOptionInsertReqDto questionOption = data.getQuestionOption().get(i);

					final QuestionOption newQuestionOption = new QuestionOption();
					newQuestionOption.setOptionLabel(questionOption.getOptionLabel());
					newQuestionOption.setOptionCorrect(questionOption.getOptionCorrect());
					newQuestionOption.setQuestion(newQuestion);
					newQuestionOption.setCreatedBy(principalService.getPrincipal());

					questionOptionDao.insert(newQuestionOption);
				}
			} else {
			}
		});

		return result;
	}

	@Override
	public List<QuestionListResDto> getAllQuestionList() {
		final List<QuestionListResDto> questionsList = new ArrayList<>();

		questionDao.getAllQuestion().forEach(question -> {
			final QuestionListResDto questionList = new QuestionListResDto();
			questionList.setQuestionName(question.getQuestion());
			questionList.setQuestionPacket(question.getQuestionPacket().getPacketQuestionName());
			questionList.setQuestionTopic(question.getQuestionTopic().getTopicName());
			questionList.setQuestionType(question.getQuestionType().getTypeQuestionName());
			questionsList.add(questionList);
		});
		return questionsList;
	}

	@Override
	public List<CandidateQuestionResDto> getCandidateQuestion() {
		final List<CandidateQuestionResDto> candidateQuestionList = new ArrayList<>();
		final List<CandidateQuestion> candidateQuestions =  questionDao.getQuestionByCandidate(principalService.getPrincipal());
		
		for(int i = 0; i < candidateQuestions.size(); i++) {
			final CandidateQuestionResDto candidateQuestion = new CandidateQuestionResDto();
			candidateQuestion.setCandidateAssignId(candidateQuestions.get(i).getCandidateAssign().getId());
			candidateQuestion.setCandidateId(candidateQuestions.get(i).getCandidate().getId());
			candidateQuestion.setHrId(candidateQuestions.get(i).getHr().getId());
			candidateQuestion.setQuestionId(candidateQuestions.get(i).getQuestion().getId());
			candidateQuestion.setTypeId(candidateQuestions.get(i).getQuestion().getQuestionType().getId());
			candidateQuestionList.add(candidateQuestion);
		}
		
		return candidateQuestionList;
	}

	@Override
	public QuestionResDto getById(Long id) {
		final Question question = questionDao.getById(id);
		
		final QuestionResDto questionDto = new QuestionResDto();
		
		questionDto.setId(question.getId());
		questionDto.setQuestion(question.getQuestion());
		questionDto.setQuestionCode(question.getQuestionCode());
		
		if (question.getQuestionType().getTypeQuestionCode().equals(QuestionTypes.OPTION.typeCode)) {
			final List<QuestionOptionResDto> optionResList = new ArrayList<>();
			questionOptionDao.getQuestionOptionByCandidateId(question.getId()).forEach(option -> {
				final QuestionOptionResDto optionRes = new QuestionOptionResDto();
				optionRes.setOptionLabel(option.getOptionLabel());
				optionRes.setId(option.getId());
				optionResList.add(optionRes);
			});
			questionDto.setQuestionOption(optionResList);
		}
		
		return questionDto;
	}

}
