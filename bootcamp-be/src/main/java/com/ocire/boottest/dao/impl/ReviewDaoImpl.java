package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.ReviewDao;
import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.dto.review.ReviewResDto;
import com.ocire.boottest.model.Review;
import com.ocire.boottest.model.User;

@Repository
@Profile("native-query")
public class ReviewDaoImpl implements ReviewDao {
	@PersistenceContext
	private EntityManager em;
	private UserDao userDao;

	public ReviewDaoImpl(UserDao userDao) {
		this.userDao = userDao;
	}

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
		final String sql = "SELECT id, ver, id_reviewer FROM t_review WHERE id_candidate = :candidateId";
		Review review = null;

		final Object userObj = this.em.createNativeQuery(sql).setParameter("candidateId", candidateId)
				.getSingleResult();

		final Object[] userArr = (Object[]) userObj;

		if (userArr.length > 0) {
			review = new Review();
			review.setId(Long.valueOf(userArr[0].toString()));
			review.setVer(Integer.valueOf(userArr[1].toString()));
			final User reviewer = userDao.getById(Long.valueOf(userArr[2].toString()));
			review.setReviewer(reviewer);
		}
		
		return review;
	}

	@Override
	public List<Review> getByReviewerId(Long reviewerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
