package com.ocire.boottest.dao.impl.springDataJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.dao.FileDao;
import com.ocire.boottest.model.File;
import com.ocire.boottest.repo.FileRepo;

@Repository
@Profile("springdatajpa-query")
public class FileDaoSpringDataJpaImpl implements FileDao {
	@PersistenceContext
	private EntityManager em;
	private final FileRepo fileRepo;

	public FileDaoSpringDataJpaImpl(FileRepo fileRepo) {
		this.fileRepo = fileRepo;
	}

	@Override
	public File getById(Long id) {
		final File file = fileRepo.findById(id).get();
		return file;
	}

	@Override
	public File insert(File file) {
		fileRepo.save(file);
		return file;
	}

	@Override
	public Boolean deleteById(Long id) {

		final int result = fileRepo.removeById(id);
		return result > 0;

	}

}
