package com.ocire.boottest.dao;

import java.util.List;

import com.ocire.boottest.model.QuestionPacket;

public interface QuestionPacketDao {
	QuestionPacket insert(QuestionPacket questionPacket) ;

	List<QuestionPacket> getAll() ;
	
	QuestionPacket getById(Long id) ;
}
