package com.ocire.boottest.dao;


import com.ocire.boottest.model.File;

public interface FileDao {
	File getById(Long id) ;
	
	File insert(File file) ;
	
	Boolean deleteById(Long id) ;
}