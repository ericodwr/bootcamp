package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.model.Review;

@Repository
@Profile("hql-query")
public class ReviewDaoHqlImpl implements ReviewDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Review insert(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public Review getById(Long id) {
		final Review review = this.em.find(Review.class, id);
		return review;
	}

	@Override
	public Review getByCandidateId(Long candidateId) {
		final String sql = "SELECT r.id, r.ver FROM Review r WHERE r.candidate.id = :candidateId";
		Review review = null;
		
		final Object userObj = this.em.createQuery(sql).setParameter("candidateId", candidateId).getSingleResult();
		
		final Object[] userArr = (Object[]) userObj;
		
		if (userArr != null) {
			review = new Review();
			review.setId(Long.valueOf(userArr[0].toString()));
			review.setVer(Integer.valueOf(userArr[1].toString()));
		}

		return review;

	}

	@Override
	public List<Review> getByReviewerId(Long reviewerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
