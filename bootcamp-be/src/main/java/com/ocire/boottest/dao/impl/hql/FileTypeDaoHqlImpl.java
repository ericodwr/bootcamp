package com.ocire.boottest.dao.impl.hql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileTypeDao;
import com.ocire.boottest.model.FileType;

@Repository
@Profile("hql-query")
public class FileTypeDaoHqlImpl implements FileTypeDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<FileType> getAllFileType() {
		final String sql = "SELECT tft FROM FileType tft";
		return this.em.createQuery(sql, FileType.class).getResultList();

	}
	
	@Override
	public FileType getById(Long id) {
		final FileType fileType = this.em.getReference(FileType.class, id);
		return fileType;
	}

}
