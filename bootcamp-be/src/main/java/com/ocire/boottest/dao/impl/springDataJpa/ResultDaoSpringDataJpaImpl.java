package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ResultDao;
import com.ocire.boottest.model.ResultStatus;
import com.ocire.boottest.repo.ResultRepo;

@Repository
@Profile("springdatajpa-query")
public class ResultDaoSpringDataJpaImpl implements ResultDao {
	@PersistenceContext
	private EntityManager em;
	private ResultRepo resultRepo;

	public ResultDaoSpringDataJpaImpl(ResultRepo resultRepo) {
		this.resultRepo = resultRepo;
	}

	@Override
	public List<ResultStatus> getResultStatus() {
		final List<ResultStatus> resultStatus = resultRepo.findAll();
		return resultStatus;
	}

	@Override
	public ResultStatus getById(Long id) {
		final ResultStatus status = resultRepo.findById(id).get();
		return status;
	}

	@Override
	public ResultStatus getByCode(String code) {
		ResultStatus status = resultRepo.getByResultCode(code);
		return status;
	}

}
