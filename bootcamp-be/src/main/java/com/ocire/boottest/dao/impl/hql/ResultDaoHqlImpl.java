package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ResultDao;
import com.ocire.boottest.model.ResultStatus;

@Repository
@Profile("hql-query")
public class ResultDaoHqlImpl implements ResultDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ResultStatus> getResultStatus() {
		final String sql = "SELECT trs FROM ResultStatus trs";

		final List<ResultStatus> resultStatus = this.em.createQuery(sql, ResultStatus.class).getResultList();
		return resultStatus;
	}

	@Override
	public ResultStatus getById(Long id) {
		final ResultStatus status = this.em.getReference(ResultStatus.class, id);
		return status;
	}
	
	@Override
	public ResultStatus getByCode(String code) {
		final String sql = "SELECT trs.id, trs.resultName, trs.resultCode, trs.ver FROM ResultStatus trs WHERE trs.resultCode = :code";

		final Object userObj = this.em.createQuery(sql).setParameter("code", code).getSingleResult();
		final Object[] userArr = (Object[]) userObj;

		ResultStatus status = null;

		if (userArr.length > 1) {
			status = new ResultStatus();
			status.setId(Long.valueOf(userArr[0].toString()));
			status.setResultName(userArr[1].toString());
			status.setResultCode(userArr[2].toString());
			status.setVer(Integer.valueOf(userArr[3].toString()));
		}
		
		return status;
	}

}
