package com.ocire.boottest.dao.impl.springDataJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileTypeDao;
import com.ocire.boottest.model.FileType;
import com.ocire.boottest.repo.FileTypeRepo;

@Repository
@Profile("springdatajpa-query")
public class FileTypeDaoSpringDataJpaImpl implements FileTypeDao {
	@PersistenceContext
	private EntityManager em;
	private final FileTypeRepo fileTypeRepo;

	public FileTypeDaoSpringDataJpaImpl(FileTypeRepo fileTypeRepo) {
		this.fileTypeRepo = fileTypeRepo;
	}

	@Override
	public List<FileType> getAllFileType() {
		final List<FileType> fileType = fileTypeRepo.findAll();
		return fileType;

	}

	@Override
	public FileType getById(Long id) {
		final FileType fileType = fileTypeRepo.findById(id).get();
		return fileType;
	}

}
