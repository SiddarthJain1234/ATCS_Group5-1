package com.atcs.SpringJobPortal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atcs.SpringJobPortal.Entity.Message;

public interface MessageRepo extends JpaRepository<Message, Integer>{

	List<Message> findByid(int companyid);
	
	
	
}
