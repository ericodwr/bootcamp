package com.ocire.boottest.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.FileDao;
import com.ocire.boottest.dao.FileTypeDao;
import com.ocire.boottest.dao.RequirementFileDao;
import com.ocire.boottest.dao.UserDao;
import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.files.FilesCandidateInsertReqDto;
import com.ocire.boottest.dto.files.FilesInsertReqDto;
import com.ocire.boottest.model.File;
import com.ocire.boottest.model.FileType;
import com.ocire.boottest.model.RequirementFile;
import com.ocire.boottest.model.User;
import com.ocire.boottest.service.FileService;
import com.ocire.boottest.service.PrincipalService;

@Service
public class FileServiceImpl implements FileService {
	private final FileTypeDao fileTypeDao;
	private final FileDao fileDao;
	private final RequirementFileDao requirementFileDao;
	private final UserDao userDao;
	@PersistenceContext
	private EntityManager em;
	private PrincipalService principalService;

	public FileServiceImpl(FileTypeDao fileTypeDao, FileDao fileDao, RequirementFileDao requirementFileDao,
			UserDao userDao, PrincipalService principalService) {
		this.fileTypeDao = fileTypeDao;
		this.fileDao = fileDao;
		this.requirementFileDao = requirementFileDao;
		this.userDao = userDao;
		this.principalService = principalService;

	}
	
	@Override
	public List<FileType> getAllFileTypes() {
		return fileTypeDao.getAllFileType();
	}
	
	@Transactional
	@Override
	public InsertResDto insert(FilesInsertReqDto data) {
		final InsertResDto result = new InsertResDto();
		final File file = new File();
		file.setFileName(data.getFileName());
		file.setFileExtens(data.getFileExtens());
		file.setCreatedBy(principalService.getPrincipal());

		final File newFile = fileDao.insert(file);

		result.setId(newFile.getId());
		result.setMessage("Insert file successfully!");
		return result;
	}

	@Transactional
	@Override
	public InsertResDto insertRequirementFile(List<FilesCandidateInsertReqDto> dataList) {
		final InsertResDto result = new InsertResDto();
		dataList.forEach(data -> {

			final File file = new File();
			file.setFileName(data.getFileName());
			file.setFileExtens(data.getFileExtens());
			file.setCreatedBy(principalService.getPrincipal());

			final File newFile = fileDao.insert(file);
			final FileType fileType = fileTypeDao.getById(data.getTypeId());
			final User candidate = userDao.getById(principalService.getPrincipal());

			final RequirementFile reqFile = new RequirementFile();
			reqFile.setCandidate(candidate);
			reqFile.setFile(newFile);
			reqFile.setType(fileType);
			reqFile.setCreatedBy(principalService.getPrincipal());

			requirementFileDao.insert(reqFile);
		});
		
		result.setId(null);
		result.setMessage("Successfully insert requirement files!");
		return result;
	}

	@Override
	public File getById(Long id) {
		final File file = fileDao.getById(id);
		return file;
	}
	
	

}
