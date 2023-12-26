package com.ocire.boottest.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileDao;
import com.ocire.boottest.model.File;

@Repository
@Profile("native-query")
public class FileDaoImpl implements FileDao {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public File getById(Long id)  {
		final File file = this.em.getReference(File.class, id);
		return file;
	}
	
	@Override
	public File insert(File file)  {
		em.persist(file);
		return file;
	}
	
	@Override
	public Boolean deleteById(Long id)  {
		final String sql = "DELETE FROM t_file WHERE id = :id";

		final int result = this.em.createNativeQuery(sql, File.class).setParameter("id", id).executeUpdate();
		return result > 0;

	}

}
