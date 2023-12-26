package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.FileType;

public interface FileTypeDao {
	List<FileType> getAllFileType();
	
	FileType getById(Long id);
}
