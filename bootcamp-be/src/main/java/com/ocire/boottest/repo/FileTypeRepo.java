package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.FileType;

@Repository
public interface FileTypeRepo extends JpaRepository<FileType, Long> {
	
}
