package com.ocire.boottest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileTypeDao;
import com.ocire.boottest.model.FileType;

@Repository
@Profile("native-query")
public class FileTypeDaoImpl implements FileTypeDao {
	@PersistenceContext
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileType> getAllFileType()  {
		final String sql = "SELECT * FROM t_file_type";
		
		return this.em.createNativeQuery(sql, FileType.class).getResultList();

	}


	@Override
	public FileType getById(Long id) {
		final FileType fileType = this.em.getReference(FileType.class, id);
		return fileType;
	}

}
