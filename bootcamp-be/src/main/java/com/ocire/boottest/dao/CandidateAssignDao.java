package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.CandidateAssign;

public interface CandidateAssignDao {
	CandidateAssign insert(CandidateAssign candidateAssign);
	
	List<CandidateAssign> getAllCandidateAssign();

	List<CandidateAssign> getAllCandidateId(Long id);

	CandidateAssign getById(Long id);
	
}
