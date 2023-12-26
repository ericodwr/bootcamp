package com.ocire.boottest.dao.impl.hql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileDao;
import com.ocire.boottest.model.File;

@Repository
@Profile("hql-query")
public class FileDaoHqlImpl implements FileDao {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public File getById(Long id)  {
		final File file = this.em.find(File.class, id);
		return file;
	}
	
	@Override
	public File insert(File file)  {
		em.persist(file);
		return file;
	}

	@Override
	public Boolean deleteById(Long id)  {
		final String sql = "DELETE FROM File WHERE id = :id";
		
		final int result = this.em.createQuery(sql, File.class).setParameter("id", id).executeUpdate();
		return result > 0;

	}

}
