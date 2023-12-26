package com.ocire.boottest.service;

import java.util.List;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.files.FilesCandidateInsertReqDto;
import com.ocire.boottest.dto.files.FilesInsertReqDto;
import com.ocire.boottest.model.File;
import com.ocire.boottest.model.FileType;

public interface FileService {
	List<FileType> getAllFileTypes();

	InsertResDto insert(FilesInsertReqDto data);

	InsertResDto insertRequirementFile(List<FilesCandidateInsertReqDto> data);
	
	File getById(Long id);
	
	
}
