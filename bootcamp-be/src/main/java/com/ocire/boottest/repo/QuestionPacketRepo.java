package com.ocire.boottest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocire.boottest.model.QuestionPacket;

@Repository
public interface QuestionPacketRepo extends JpaRepository<QuestionPacket, Long> {
	
}
