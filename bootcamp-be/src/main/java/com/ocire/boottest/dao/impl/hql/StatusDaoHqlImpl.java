package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.StatusDao;
import com.ocire.boottest.model.ProgressStatus;

@Repository
@Profile("hql-query")
public class StatusDaoHqlImpl implements StatusDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ProgressStatus> getProgressStatus() {
		final String sql = "SELECT tps FROM ProgressStatus tps";
		final List<ProgressStatus> progressStatusList = this.em.createQuery(sql, ProgressStatus.class).getResultList();

		return progressStatusList;
	}

	@Override
	public ProgressStatus getById(Long id) {
		final ProgressStatus status = this.em.find(ProgressStatus.class, id);
		return status;
	}
	
	@Override
	public ProgressStatus getByCode(String code) {
		final String sql = "SELECT ps.id, ps.statusName, ps.statusCode, ps.ver FROM ProgressStatus ps WHERE ps.statusCode = :code";

		final Object userObj = this.em.createQuery(sql).setParameter("code", code).getSingleResult();
		final Object[] userArr = (Object[]) userObj;
		
		ProgressStatus status = null;

		if (userArr.length > 1) {
			status = new ProgressStatus();
			status.setId(Long.valueOf(userArr[0].toString()));
			status.setStatusName(userArr[1].toString());
			status.setStatusCode(userArr[2].toString());
			status.setVer(Integer.valueOf(userArr[3].toString()));
		}

		return status;
	}

}
